/*
 * @author Developer
 * @version 6.0
 * 
 */
//Contact memento to handle previous state

package com.seveneleven.mycontact.contact.edit.memento;


import java.util.List;

import com.seveneleven.mycontact.contact.model.EmailAddress;
import com.seveneleven.mycontact.contact.model.PhoneNumber;
public class ContactMemento {

	private String name;
	private List<PhoneNumber> phones;
	private List<EmailAddress> emails;
	
	public ContactMemento(String name, List<PhoneNumber> phones, List<EmailAddress> emails) {
		
		this.name = name;
		this.phones = List.copyOf(phones);
		this.emails = List.copyOf(emails);
		
	}
	
	public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public List<EmailAddress> getEmails() {
        return emails;
    }
	
	
	
}
