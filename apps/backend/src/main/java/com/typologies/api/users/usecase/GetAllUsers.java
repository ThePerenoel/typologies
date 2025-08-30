package com.typologies.api.users.usecase;

import com.typologies.api.documents.dto.TypologieDto;
import com.typologies.api.documents.usecase.GetAllTypologieById;
import com.typologies.api.users.domain.UserRepository;
import com.typologies.api.users.dto.UserDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GetAllUsers {

    @Inject
    @Named("postgresUserRepository")
    UserRepository userRepository;

    public List<UserDto> act() {
        return userRepository.getAll()
                .stream()
                .map(userEntity -> {
                    return new UserDto(
                            userEntity.getId(),
                            userEntity.getFirstName(),
                            userEntity.getLastName(),
                            userEntity.getTypologies().stream().map(typologieEntity -> new TypologieDto(
                                    typologieEntity.getId(),
                                    typologieEntity.getTitle(),
                                    typologieEntity.getType(),
                                    typologieEntity.requiresSignature(),
                                    typologieEntity.requiresInitials(),
                                    typologieEntity.getEmailAdresses()
                            )).collect(Collectors.toCollection(java.util.ArrayList::new))
                    );
                }).toList();
    }

}
