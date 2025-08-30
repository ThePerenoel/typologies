package com.typologies.api.users.infra;

import com.typologies.api.documents.entity.TypologieEntity;
import com.typologies.api.users.domain.UserRepository;
import com.typologies.api.users.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Named("postgresUserRepository")
public class PostgresUserRepository implements UserRepository {

    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    @Override
    public List<UserEntity> getAll() {
        return entityManager.createQuery("Select u from UserEntity u", UserEntity.class).getResultList();
    }

    @Override
    @Transactional
    public void associate(Long userId, Long typologieId) {
        TypologieEntity typologieEntity = entityManager.find(TypologieEntity.class, typologieId);
        UserEntity userEntity = entityManager.find(UserEntity.class, userId);
        userEntity.getTypologies().add(typologieEntity);
        entityManager.persist(userEntity);
    }
}
