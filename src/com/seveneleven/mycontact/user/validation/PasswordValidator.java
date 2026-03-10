/*
 * @author Developer
 * @version 2.0
 * 
 */

//Password validation to ensure password contains 8 characters of both cases and symbols
package com.seveneleven.mycontact.user.validation;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])" +       
            "(?=.*[A-Z])" +        
            "(?=.*\\d)" +          
            "(?=.*[@#$%^&+=!])" +  
            ".{8,}$";               

    private static final Pattern pattern =
            Pattern.compile(PASSWORD_REGEX);

    private PasswordValidator() {
        
    }

    public static boolean isValid(String password) {

        if (password == null || password.isBlank()) {
            return false;
        }

        return pattern.matcher(password).matches();
    }
}