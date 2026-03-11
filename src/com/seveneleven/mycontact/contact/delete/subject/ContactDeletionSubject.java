/*
 * @author developer
 * @version 7.0
 * 
 */
//manages all observers, notifies observers

package com.seveneleven.mycontact.contact.delete.subject;

import java.util.ArrayList;
import java.util.List;

import com.seveneleven.mycontact.contact.delete.observer.ContactObserver;
import com.seveneleven.mycontact.contact.model.Contact;
public class ContactDeletionSubject {

	private List<ContactObserver> observers = new ArrayList<>();
	
	public void addObserver(ContactObserver observer) {
		observers.add(observer);
		
	}
	
	public void notifyObservers(Contact contact) {
		for(ContactObserver obs : observers) {
			obs.onContactDeleted(contact);
			
		}
	}
}
