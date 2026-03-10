/*
 * @author Developer
 * @version 4.0
 * Entrypoint
 */


//Main function for first two use cases

package com.seveneleven.mycontact.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.seveneleven.mycontact.contact.factory.ContactFactory;
import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.service.ContactService;
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
            
         // UC-04 : Create Contact

            ContactService contactService = new ContactService();

            Contact contact = ContactFactory.createContact(
            		"PERSON",
                    "Rohit Sharma",
                    List.of("9876543210", "9998887777"),
                    List.of("rohit@email.com")
            );

            contactService.addContact(contact);

            System.out.println("Contact Created: " + contact.getName());

        } else {
            System.out.println("Login Failed!");
        }
    }
}