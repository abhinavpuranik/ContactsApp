
/*
 * @author Developer
 * @version 2.0
 * 
 */

//update name implementation of command
package com.seveneleven.mycontact.user.profile.command;
import com.seveneleven.mycontact.user.model.User;

public class UpdateNameCommand implements ProfileCommand{
	
	private User user;
	private String newName;
	
	public UpdateNameCommand(User user, String newName) {
		this.user = user;
		this.newName = newName;
		
	}

	@Override
	public void execute() {
		
		user.setUserName(newName);
		System.out.println("Username updated successfully.");
		
	
		
	}

}
