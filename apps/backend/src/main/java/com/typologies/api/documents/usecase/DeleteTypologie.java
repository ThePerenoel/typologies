package com.typologies.api.documents.usecase;

import com.typologies.api.documents.domain.TypologieRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteTypologie {

    @Inject
    TypologieRepository typologieRepository;

    public void act(String id) {
        typologieRepository.delete(id);
    }

}
