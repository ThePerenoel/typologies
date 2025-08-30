package com.typologies.api.users.domain;

import com.typologies.api.users.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    List<UserEntity> getAll();
    void associate(Long userId, Long typologieId);
    void add(UserEntity userEntity);
}
