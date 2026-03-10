/*
 * @author Developer
 * @version 2.0
 * 
 */

//Simple Validation

package com.seveneleven.mycontact.user.auth.strategy;
import com.seveneleven.mycontact.user.auth.Authentication;
import com.seveneleven.mycontact.user.auth.PasswordHasher;
import com.seveneleven.mycontact.user.model.User;

import java.util.List;
import java.util.Optional;
public class BasicAuthStrategy implements Authentication {
	private List<User> users;
	public BasicAuthStrategy(List<User> users) {
		this.users = users;
	}
	
	@Override
	public Optional<User> login(String email, String password) {

	    String hashed = PasswordHasher.hash(password);

	    // Check if email exists
	    Optional<User> userOptional = users.stream()
	            .filter(u -> u.getEmailAddress().equals(email))
	            .findFirst();

	    if (userOptional.isEmpty()) {
	        System.out.println("Email not found.");
	        return Optional.empty();
	    }

	    System.out.println("Email found.");

	    User user = userOptional.get();

	    // Check password
	    if (!user.getPassword().equals(hashed)) {
	        System.out.println("Password incorrect.");
	        return Optional.empty();
	    }

	    System.out.println("Password correct.");

	    return Optional.of(user);
	}
}
