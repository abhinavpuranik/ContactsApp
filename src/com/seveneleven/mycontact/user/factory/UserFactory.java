//Factory Pattern to create the user object of the required type

package com.seveneleven.mycontact.user.factory;

import com.seveneleven.mycontact.user.builder.*;
import com.seveneleven.mycontact.user.model.*;

public class UserFactory {
	public static User createUser(String type, UserBuilder builder) {
		switch(type.toUpperCase()) {
		case "FREE":
			return new FreeUser(
				builder.getEmail(),
				builder.getPassword(),
				builder.getUserName(),
				builder.getAge()
				
			);
		case "PREMIUM":
			return new PremiumUser(
					builder.getEmail(),
					builder.getPassword(),
					builder.getUserName(),
					builder.getAge()
					);
			
		default:
			throw new IllegalArgumentException("Invalid user type");

		
		}
	}
}
