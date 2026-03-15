
/*
 * @author Developer
 * @version 6.0
 * 
 * Contact model
 */

package com.seveneleven.mycontact.contact.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.seveneleven.mycontact.contact.edit.memento.ContactMemento;

public abstract class Contact {

    protected UUID id;
    protected String name;
    private int contactCount = 5;

    protected List<PhoneNumber> phoneNumbers;
    protected List<EmailAddress> emails;
    private List<String> tags = new ArrayList<>();

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

    public LocalDateTime getCreatedAt() {
    	return createdAt;
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
		this.name = newName; {
			
		}
		
		
	}
	public List<String> getTags() {
	    return List.copyOf(tags);
	}

	public void addTag(String tag) {
	    tags.add(tag.toLowerCase());
	}
	public void removeTag(String tag) {
	    tags.remove(tag.toLowerCase());
	}
	@Override
	public String toString() {

	    return "Contact{" +
	            "name='" + name + '\'' +
	            ", phones=" + phoneNumbers +
	            ", emails=" + emails +
	            ", tags=" + tags +
	            '}';
	}

	public void incrementContactCount() {
	    contactCount++;
	}

	public int getContactCount() {
	    return contactCount;
	}
}