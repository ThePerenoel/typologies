package com.typologies.api.users.domain;

import com.typologies.api.users.entity.UserEntity;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<UserEntity> getAll();
}
