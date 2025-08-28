package com.typologies.api.documents.domain;

import com.typologies.api.documents.entity.TypologieEntity;

import java.util.List;
import java.util.UUID;

public interface TypologieRepository {
    List<TypologieEntity> getAll();
    void save(TypologieEntity typologieEntity);
    void delete(String id);
    List<TypologieEntity> getForIds(List<UUID> ids);
}
