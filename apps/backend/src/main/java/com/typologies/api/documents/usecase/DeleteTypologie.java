package com.typologies.api.documents.usecase;

import com.typologies.api.documents.domain.TypologieRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class DeleteTypologie {

    @Inject
    @Named("postgres")
    TypologieRepository typologieRepository;

    public void act(Long id) {
        typologieRepository.delete(id);
    }

}
