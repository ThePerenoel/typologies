package com.typologies.api.documents.infra;

import com.typologies.api.documents.domain.TypologieRepository;
import com.typologies.api.documents.entity.TypologieEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.*;

@ApplicationScoped
public class InMemoryTypologieRepository implements TypologieRepository {

    private final List<String> emails = List.of("aaaa@gmail.com, bbbb@gmail.com, ccc@gmail.com");

    private List<TypologieEntity> store = new ArrayList<>(Arrays.asList(
        new TypologieEntity("Fiche de paie", "Géneral", true,  false, emails),
        new TypologieEntity("Contrat de travail", "Géneral", true,  true,  emails),
        new TypologieEntity("Bulletin de salaire", "Géneral", false, false, emails),
        new TypologieEntity("Note de frais", "Géneral", true,  false, emails),
        new TypologieEntity("Facture", "Géneral", false, false, emails)
    ));

    @Override
    public List<TypologieEntity> getAll() {
        return store;
    }

    @Override
    public void save(TypologieEntity typologieEntity) {
        store.add(typologieEntity);
    }

    @Override
    public void delete(String id) {
        store.stream()
                .filter(typologieEntity -> typologieEntity.getId().equals(UUID.fromString(id)))
                .findFirst()
                .ifPresent(typologieEntity -> store.remove(typologieEntity));
    }

    @Override
    public void modify(TypologieEntity typologieEntity) {

    }
}
