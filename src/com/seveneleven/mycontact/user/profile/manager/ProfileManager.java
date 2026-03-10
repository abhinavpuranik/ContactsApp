/*
 * @author Developer
 * @version 3.0
 * 
 */

//command executer

package com.seveneleven.mycontact.user.profile.manager;
import com.seveneleven.mycontact.user.profile.command.ProfileCommand;
public class ProfileManager {
	
	public void executeCommand(ProfileCommand command) {
		command.execute();
		
	}

}
