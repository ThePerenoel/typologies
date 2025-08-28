package com.typologies.api.documents.usecase;

import com.typologies.api.documents.domain.TypologieRepository;
import com.typologies.api.documents.dto.TypologieDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GetAllTypologieByUuid {

    @Inject
    TypologieRepository typologieRepository;

    public List<TypologieDto> act(ArrayList<UUID> typologieIds) {
        return typologieRepository.getForIds(typologieIds)
                .stream()
                .map(typologieEntity -> new TypologieDto(
                        typologieEntity.getId().toString(),
                        typologieEntity.getTitle(),
                        typologieEntity.getType(),
                        typologieEntity.requiresSignature(),
                        typologieEntity.requiresSignature(),
                        typologieEntity.getEmailAdresses()
                )).toList();
    }

}
