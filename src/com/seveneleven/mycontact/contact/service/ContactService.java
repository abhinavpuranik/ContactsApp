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

import com.seveneleven.mycontact.contact.model.Contact;

public class ContactService {

    private List<Contact> contacts = new ArrayList<>();

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
}