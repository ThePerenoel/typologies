package com.typologies.api.documents.usecase;

import com.typologies.api.documents.domain.TypologieRepository;
import com.typologies.api.documents.domain.TypologieType;
import com.typologies.api.documents.dto.TypologieDto;
import com.typologies.api.documents.entity.TypologieEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class CreateTypologie {

    @Inject
    @Named("postgres")
    TypologieRepository typologieRepository;

    public void act(TypologieDto typologieDto) {
        typologieRepository.save(new TypologieEntity(
                typologieDto.getTitle(),
                TypologieType.valueOf(typologieDto.getType()).getLabel(),
                typologieDto.isRequiresSignature(),
                typologieDto.isRequiresInitials(),
                typologieDto.getEmailAdresses()
        ));
    }

}
