/*
 * @author developer
 * @version 7.0
 * 
 */
//Logs upon deletion

package com.seveneleven.mycontact.contact.delete.observer;

import com.seveneleven.mycontact.contact.model.Contact;

public class ContactDeletionLogger implements ContactObserver {

    @Override
    public void onContactDeleted(Contact contact) {

        System.out.println("LOG: Contact deleted -> " + contact.getName());
    }
}