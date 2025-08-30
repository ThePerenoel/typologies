package com.typologies.api.documents.usecase;

import com.typologies.api.documents.domain.TypologieRepository;
import com.typologies.api.documents.dto.TypologieDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GetAllTypologieById {

    @Inject
    @Named("postgres")
    TypologieRepository typologieRepository;

    public List<TypologieDto> act(ArrayList<Long> typologieIds) {
        return typologieRepository.getForIds(typologieIds)
                .stream()
                .map(typologieEntity -> new TypologieDto(
                        typologieEntity.getId(),
                        typologieEntity.getTitle(),
                        typologieEntity.getType(),
                        typologieEntity.requiresSignature(),
                        typologieEntity.requiresSignature(),
                        typologieEntity.getEmailAdresses()
                )).toList();
    }

}
