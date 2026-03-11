/*
 * @author Developer
 * @version 4.0
 * 
 */
//service for adding to contact list

package com.seveneleven.mycontact.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.seveneleven.mycontact.contact.delete.observer.ContactObserver;
import com.seveneleven.mycontact.contact.delete.subject.ContactDeletionSubject;
import com.seveneleven.mycontact.contact.model.Contact;

public class ContactService {

    private List<Contact> contacts = new ArrayList<>();
    private ContactDeletionSubject deletionSubject = new ContactDeletionSubject();
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully");
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
    
    public Optional<Contact> findContactByName(String name) {

        return contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
    }
    
    
    public void addDeletionObserver(ContactObserver observer) {
        deletionSubject.addObserver(observer);
    }
    
    public void deleteContact(String name) {
    	
    	Optional<Contact> contactOpt = 
    			contacts.stream()
    					.filter(c -> c.getName().equalsIgnoreCase(name))
    					.findFirst();
    	
    
      	if(contactOpt.isEmpty()) {
      		throw new RuntimeException("Contact not found");
      	}
      	
      	Contact contact = contactOpt.get();
      	contacts.remove(contact);
      	deletionSubject.notifyObservers(contact);
      	
      	System.out.println("Contact deleted successfully");
      	
      	
}
}