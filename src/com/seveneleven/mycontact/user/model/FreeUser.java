//Free user model
package com.seveneleven.mycontact.user.model;

public class FreeUser extends User {

	public FreeUser(String emailAddress, String userName, String password, int age) {
		super(emailAddress, userName, password, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getUserType() {
		return "FREE";
		// TODO Auto-generated method stub
		
	}
	
}
