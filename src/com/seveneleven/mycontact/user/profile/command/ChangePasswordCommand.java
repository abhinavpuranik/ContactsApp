/*
 * @author Developer
 * @version 3.0
 * 
 */

//change Password implementation of command

package com.seveneleven.mycontact.user.profile.command;

import com.seveneleven.mycontact.user.auth.PasswordHasher;
import com.seveneleven.mycontact.user.model.User;

public class ChangePasswordCommand implements ProfileCommand {

    private User user;
    private String newPassword;

    public ChangePasswordCommand(User user, String newPassword) {
        this.user = user;
        this.newPassword = newPassword;
    }

    @Override
    public void execute() {

        String hashed = PasswordHasher.hash(newPassword);
        user.setPassword(hashed);

        System.out.println("Password changed successfully.");
    }
}