//Abstract user model with getters and setters. Encapsulation of user data
package com.seveneleven.mycontact.user.model;

public abstract class User {

    private String emailAddress;
    private String password;
    private String userName;
    private int age;

    protected User(String emailAddress, String password, String userName, int age) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.userName = userName;
        this.age = age;
        
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    protected void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
    	return password;
    }

    public String getUserName() {
        return userName;
    }
    
    protected void setAge(int age) {
    	this.age = age;
    }
   
    public int getAge(int age) {
    	return age;
    }

    public abstract String getUserType();
}