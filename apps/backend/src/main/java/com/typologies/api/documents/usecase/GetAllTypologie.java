package com.typologies.api.documents.usecase;

import com.typologies.api.documents.domain.TypologieRepository;
import com.typologies.api.documents.dto.TypologieDto;
import com.typologies.api.documents.entity.TypologieEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetAllTypologie {

    @Inject
    TypologieRepository typologieRepository;

    public List<TypologieDto> act() {
        return typologieRepository.getAll()
                .stream()
                .map(GetAllTypologie::convertToDto)
                .toList();
    }

    private static TypologieDto convertToDto(TypologieEntity typologieEntity) {
        return new TypologieDto(
                typologieEntity.getTitle(),
                typologieEntity.getType(),
                typologieEntity.requiresSignature(),
                typologieEntity.requiresSignature(),
                typologieEntity.getEmailAdresses()
        );
    }

}
