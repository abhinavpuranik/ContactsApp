//Password hasher using sha digestion

package com.seveneleven.mycontact.user.auth;
import java.security.MessageDigest;

public class PasswordHasher {

	public static String hash(String password) {
		try {
			MessageDigest message = MessageDigest.getInstance("SHA-256");
			byte[] hashed = message.digest(password.getBytes());
			StringBuilder builder = new StringBuilder();
			for(byte hashed_byte : hashed) {
				builder.append(String.format("%02x", hashed_byte));
				
			}
			return builder.toString();
		} catch(Exception e) {
			
			throw new RuntimeException("Error with password");
		}
	}
}
