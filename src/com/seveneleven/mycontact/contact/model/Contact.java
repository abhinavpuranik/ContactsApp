
/*
 * @author Developer
 * @version 6.0
 * 
 * Contact model
 */

package com.seveneleven.mycontact.contact.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.seveneleven.mycontact.contact.edit.memento.ContactMemento;

public abstract class Contact {

    protected UUID id;
    protected String name;

    protected List<PhoneNumber> phoneNumbers;
    protected List<EmailAddress> emails;

    protected LocalDateTime createdAt;

    public Contact(String name,
                   List<PhoneNumber> phoneNumbers,
                   List<EmailAddress> emails) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public List<PhoneNumber> getPhoneNumbers() {
    	return phoneNumbers;
    }

	public List<EmailAddress> getEmails() {
		return emails;
	
	}
	
	public ContactMemento saveState() {
	    return new ContactMemento(name, phoneNumbers, emails);
	}
	
	public void restoreState(ContactMemento memento) {

	    this.name = memento.getName();
	    this.phoneNumbers = memento.getPhones();
	    this.emails = memento.getEmails();
	}

	public void setName(String newName) {
		this.name = newName;
		
		
	}

}