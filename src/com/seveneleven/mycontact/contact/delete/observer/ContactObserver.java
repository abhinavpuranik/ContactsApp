
/*
 * @author developer
 * @version 7.0
 * 
 */
//Observer interface
package com.seveneleven.mycontact.contact.delete.observer;

import com.seveneleven.mycontact.contact.model.Contact;

public interface ContactObserver {

    void onContactDeleted(Contact contact);

}