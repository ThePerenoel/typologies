package com.typologies.api.users.usecase;

import com.typologies.api.users.domain.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class AssociateTypologie {

    @Inject
    @Named("postgresUserRepository")
    UserRepository userRepository;

    public void act(Long userId, Long typologieId) {
        userRepository.associate(userId, typologieId);
    }

}
