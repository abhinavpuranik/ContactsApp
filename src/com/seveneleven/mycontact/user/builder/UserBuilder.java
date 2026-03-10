/*
 * @author Developer
 * @version 2.0
 * 
 */

//Builder Pattern for object creation logic
package com.seveneleven.mycontact.user.builder;
import com.seveneleven.mycontact.user.model.User;
public class UserBuilder {

	private String emailAddress;
	private String password;
	private String userName;
	private int age;
	
	public UserBuilder setEmail(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}
	
	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserBuilder setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	
	public UserBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	
	
	public String getEmail() { 
		return emailAddress; 
		};
	
	public String getPassword() {
		return password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public int getAge() {
		return age;
	}
	
	
}
