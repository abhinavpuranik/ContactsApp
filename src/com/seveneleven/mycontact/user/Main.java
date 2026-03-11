/*
 * @author Developer
7 * @version .0
 * Entrypoint
 */


//Main function entrypoint

package com.seveneleven.mycontact.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.seveneleven.mycontact.contact.edit.command.CommandHistory;
import com.seveneleven.mycontact.contact.edit.command.EditContactCommand;
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
import java.util.Optional;

import com.seveneleven.mycontact.contact.view.BasicContactView;
import com.seveneleven.mycontact.contact.view.ContactView;
import com.seveneleven.mycontact.contact.view.decorator.EmailDisplayDecorator;
import com.seveneleven.mycontact.contact.view.decorator.PhoneDisplayDecorator;
import com.seveneleven.mycontact.contact.delete.observer.ContactDeletionLogger;

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
            
         // UC-05 : View Contact Details

            Optional<Contact> found = contactService.findContactByName("Rohit Sharma");

            if(found.isPresent()) {

                Contact contactToView = found.get();

                ContactView view = new BasicContactView(contactToView);

                view = new PhoneDisplayDecorator(view, contactToView);
                view = new EmailDisplayDecorator(view, contactToView);

                System.out.println("\n----- Contact Details -----");
                System.out.println(view.display());
            }
         // UC-06 : Edit Contact

            CommandHistory history = new CommandHistory();

            Optional<Contact> contactOpt =
                    contactService.findContactByName("Rohit Sharma");

            if(contactOpt.isPresent()) {

                Contact contact2 = contactOpt.get();

                EditContactCommand editCommand =
                        new EditContactCommand(contact2, "Rohit S");

                history.execute(editCommand);

                System.out.println("Updated Contact Name: " + contact2.getName());

                // Undo change
                history.undo();

                System.out.println("After Undo: " + contact2.getName());
            }
            
         // UC-07 : Delete Contact

            contactService.addDeletionObserver(new ContactDeletionLogger());

            System.out.println("\nDeleting contact...");

            try {

                contactService.deleteContact("Rohit Sharma");

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }
            
            

        } else {
            System.out.println("Login Failed!");
        }
    }
}