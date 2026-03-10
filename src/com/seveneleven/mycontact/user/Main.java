/*
 * @author Developer
 * @version 3.0
 * Entrypoint
 */


//Main function for first two use cases

package com.seveneleven.mycontact.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.seveneleven.mycontact.user.auth.Authentication;
import com.seveneleven.mycontact.user.auth.AuthenticationContext;
import com.seveneleven.mycontact.user.auth.UserService;
import com.seveneleven.mycontact.user.auth.session.SessionManager;
import com.seveneleven.mycontact.user.auth.strategy.BasicAuthStrategy;
import com.seveneleven.mycontact.user.model.User;
import com.seveneleven.mycontact.user.profile.command.ChangePasswordCommand;
import com.seveneleven.mycontact.user.profile.command.UpdateNameCommand;
import com.seveneleven.mycontact.user.profile.manager.ProfileManager;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        User user = service.register(
                "FREE",
                "abhinav@email.com",
                "Password@123",   // must match validator rules, throws exception otherwise
                "Abhinav"
        );

        List<User> users = new ArrayList<>();
        users.add(user);
        
        System.out.println("Actually stored in user object: " + user.getPassword());

        Authentication authStrategy = new BasicAuthStrategy(users);
        AuthenticationContext context = new AuthenticationContext(authStrategy);

        Optional<User> loggedIn =
                context.login("abhinav@email.com", "Password@123");

        if (loggedIn.isPresent()) {

            SessionManager.getInstance()
                    .createSession(loggedIn.get());

            System.out.println("Login Successful!");
            System.out.println("Session User: " +
                    SessionManager.getInstance()
                            .getLoggedInUser()
                            .getUserName());
            
            User loggedUser = SessionManager.getInstance().getLoggedInUser();

            ProfileManager manager = new ProfileManager();

            manager.executeCommand(
                    new UpdateNameCommand(loggedUser, "Abhinav P")
            );

            manager.executeCommand(
                    new ChangePasswordCommand(loggedUser, "NewPass@123")
            );

            System.out.println("Updated Name: " + loggedUser.getUserName());

        } else {
            System.out.println("Login Failed!");
        }
    }
}