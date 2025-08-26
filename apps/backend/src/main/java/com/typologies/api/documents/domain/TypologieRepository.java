package com.typologies.api.documents.domain;

import com.typologies.api.documents.entity.TypologieEntity;

import java.util.List;

public interface TypologieRepository {
    List<TypologieEntity> getAll();
    void save(TypologieEntity typologieEntity);
}
