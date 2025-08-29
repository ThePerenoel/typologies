package com.typologies.api.users.usecase;

import com.typologies.api.documents.dto.TypologieDto;
import com.typologies.api.documents.usecase.GetAllTypologieByUuid;
import com.typologies.api.users.domain.UserRepository;
import com.typologies.api.users.dto.UserDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetAllUsers {

    @Inject
    UserRepository userRepository;

    @Inject
    GetAllTypologieByUuid getAllTypologieByUuid;

    public List<UserDto> act() {
        return userRepository.getAll()
                .stream()
                .map(userEntity -> {
                    return new UserDto(
                            userEntity.getId(),
                            userEntity.getFirstName(),
                            userEntity.getLastName(),
                            getAllTypologieByUuid.act(userEntity.getTypologies())
                    );
                }).toList();
    }

}
