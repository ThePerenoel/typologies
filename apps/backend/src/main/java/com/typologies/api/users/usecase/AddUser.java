package com.typologies.api.users.usecase;

import com.typologies.api.users.domain.UserRepository;
import com.typologies.api.users.dto.UserDto;
import com.typologies.api.users.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class AddUser {

    @Inject
    @Named("postgresUserRepository")
    UserRepository userRepository;

    public void act(UserDto userDto) {
        userRepository.add(new UserEntity(userDto.getFirstName(), userDto.getLastName()));
    }
}
