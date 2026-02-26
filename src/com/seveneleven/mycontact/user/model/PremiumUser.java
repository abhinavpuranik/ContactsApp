//Premium User Model
package com.seveneleven.mycontact.user.model;

public class PremiumUser extends User {

    public PremiumUser(String email, String password, String userName, int age) {
        super(email, password, userName, age);
    }

    @Override
    public String getUserType() {
        return "PREMIUM";
    }
}