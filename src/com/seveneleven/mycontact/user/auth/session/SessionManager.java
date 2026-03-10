/*
 * @author Developer
 * @version 2.0
 * 
 */

//create and return sessions

package com.seveneleven.mycontact.user.auth.session;
import com.seveneleven.mycontact.user.model.User;


public class SessionManager {
	private static SessionManager instance;
	private User loggedInUser;
	
	private SessionManager() {};
	public static SessionManager getInstance() {
		if(instance == null) {
			instance = new SessionManager();
			
		}
		return instance;
	}
	
	public void createSession(User user) {
		this.loggedInUser = user;
	}
	
	public User getLoggedInUser() {
		return loggedInUser;
	}
	
	public void invalidateSession() {
		loggedInUser = null;
	}
}
