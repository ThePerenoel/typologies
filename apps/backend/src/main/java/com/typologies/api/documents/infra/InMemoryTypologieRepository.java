package com.typologies.api.documents.infra;

import com.typologies.api.documents.domain.TypologieRepository;
import com.typologies.api.documents.entity.TypologieEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class InMemoryTypologieRepository implements TypologieRepository {

    private final List<String> emails = Arrays.asList("aaaa@gmail.com, bbbb@gmail.com, ccc@gmail.com");

    private final List<TypologieEntity> store = Arrays.asList(
        new TypologieEntity("Fiche de paie", "Géneral", true,  false, emails),
        new TypologieEntity("Contrat de travail", "Géneral", true,  true,  emails),
        new TypologieEntity("Bulletin de salaire", "Géneral", false, false, emails),
        new TypologieEntity("Note de frais", "Géneral", true,  false, emails),
        new TypologieEntity("Facture", "Géneral", false, false, emails)
    );

    @Override
    public List<TypologieEntity> getAll() {
        return store;
    }

    @Override
    public void save(TypologieEntity typologieEntity) {
        store.add(typologieEntity);
    }
}
