
//check validation and create builder, call factory

package com.seveneleven.mycontact.user.auth;
import com.seveneleven.mycontact.user.builder.UserBuilder;
import com.seveneleven.mycontact.user.factory.UserFactory;
import com.seveneleven.mycontact.user.model.User;
import com.seveneleven.mycontact.user.validation.EmailValidator;
import com.seveneleven.mycontact.user.validation.PasswordValidator;
public class UserService {

	public User register(String type, String email, String password, String username) {
		if(!EmailValidator.isValid(email))
		{
			throw new IllegalArgumentException("Invalid Email");
		}
		
		if(!PasswordValidator.isValid(password)) {
			throw new IllegalArgumentException("Weak Password");
		}
		
		String hashedPassword = PasswordHasher.hash(password);
		
		System.out.println("Raw password: " + password);
		System.out.println("Hashed password stored: " + hashedPassword);
		UserBuilder builder = new UserBuilder()
				.setEmail(email)
				.setPassword(hashedPassword)
				.setUserName(username);
				
	
		return UserFactory.createUser(type, builder);
	}
}
