package com.seveneleven.mycontact.user.auth.strategy;

import com.seveneleven.mycontact.user.auth.Authentication;
import com.seveneleven.mycontact.user.model.User;

import java.util.Optional;

public class OAuthStrategy implements Authentication {

    @Override
    public Optional<User> login(String email, String password) {
        System.out.println("Redirecting to OAuth provider...");
        return Optional.empty(); // simulate
    }
}