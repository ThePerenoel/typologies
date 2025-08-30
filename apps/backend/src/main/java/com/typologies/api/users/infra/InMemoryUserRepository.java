package com.typologies.api.users.infra;

import com.typologies.api.users.domain.UserRepository;
import com.typologies.api.users.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@ApplicationScoped
@Named("inMemoryUserRepository")
public class InMemoryUserRepository implements UserRepository {

    private ArrayList<UserEntity> store = new ArrayList<>(
            Arrays.asList(
                    new UserEntity( "John", "Doe", new ArrayList<>()),
                    new UserEntity("Jane", "Doe", new ArrayList<>()),
                    new UserEntity("Jim", "Doe", new ArrayList<>())
            )
    );

    @Override
    public ArrayList<UserEntity> getAll() {
        return store;
    }

    @Override
    public void associate(Long userId, Long typologieId) {
        Optional<UserEntity> first = store.stream()
                .filter(userEntity -> userEntity.getId().equals(userId))
                .findFirst();
        //first.ifPresent(userEntity -> userEntity.getTypologies().add(typologieId));
    }

    @Override
    public void add(UserEntity userEntity) {
        store.add(userEntity);
    }

}
