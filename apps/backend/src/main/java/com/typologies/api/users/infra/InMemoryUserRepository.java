package com.typologies.api.users.infra;

import com.typologies.api.users.domain.UserRepository;
import com.typologies.api.users.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class InMemoryUserRepository implements UserRepository {

    private ArrayList<UserEntity> store = new ArrayList<>(
            Arrays.asList(
                    new UserEntity(UUID.randomUUID().toString(), "John", "Doe", new ArrayList<>()),
                    new UserEntity(UUID.randomUUID().toString(), "Jane", "Doe", new ArrayList<>()),
                    new UserEntity(UUID.randomUUID().toString(), "Jim", "Doe", new ArrayList<>())
            )
    );

    @Override
    public ArrayList<UserEntity> getAll() {
        return store;
    }

    @Override
    public void associate(String userId, Long typologieId) {
        Optional<UserEntity> first = store.stream()
                .filter(userEntity -> userEntity.getId().equals(userId))
                .findFirst();
        first.ifPresent(userEntity -> userEntity.getTypologies().add(typologieId));
    }

}
