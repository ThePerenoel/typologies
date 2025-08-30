package com.typologies.api.documents.infra;

import com.typologies.api.documents.domain.TypologieRepository;
import com.typologies.api.documents.entity.TypologieEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
@Named("postgres")
public class PostgresTypologieRepository implements TypologieRepository {

    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    @Override
    public List<TypologieEntity> getAll() {
        return entityManager.createQuery("SELECT t from TypologieEntity t", TypologieEntity.class).getResultList();
    }

    @Override
    @Transactional
    public void save(TypologieEntity typologieEntity) {
        entityManager.persist(typologieEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        TypologieEntity typologieEntity = entityManager.find(TypologieEntity.class, id);
        if (typologieEntity == null) {
            throw new NotFoundException("Typologie with id" + id + "not found");
        }
        entityManager.remove(typologieEntity);
    }

    @Override
    public List<TypologieEntity> getForIds(List<Long> ids) {
        return entityManager.createQuery("SELECT t from TypologieEntity t where t.id in (:ids)", TypologieEntity.class).getResultList();
    }
}
