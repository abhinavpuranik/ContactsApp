/*
 * @author Developer
 * @version 2.0
 * 
 */

package com.seveneleven.mycontact.user.auth;

import com.seveneleven.mycontact.user.model.User;

import java.util.Optional;

public class AuthenticationContext {

    private Authentication strategy;

    public AuthenticationContext(Authentication strategy) {
        this.strategy = strategy;
    }

    public Optional<User> login(String email, String password) {
        return strategy.login(email, password);
    }

    public void setStrategy(Authentication strategy) {
        this.strategy = strategy;
    }
}