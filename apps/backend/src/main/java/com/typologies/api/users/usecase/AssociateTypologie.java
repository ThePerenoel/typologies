package com.typologies.api.users.usecase;

import com.typologies.api.users.domain.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AssociateTypologie {

    @Inject
    UserRepository userRepository;

    public void act(String userId, Long typologieId) {
        userRepository.associate(userId, typologieId);
    }

}
