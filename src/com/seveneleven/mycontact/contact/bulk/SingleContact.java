
/*
 * @author developer
 * @version 8.0
 * component interface
 * For a single contact
 */

package com.seveneleven.mycontact.contact.bulk;

import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.service.ContactService;

public class SingleContact implements ContactComponent {

    private Contact contact;
    private ContactService service;

    public SingleContact(Contact contact, ContactService service) {
        this.contact = contact;
        this.service = service;
    }

    @Override
    public void delete() {

        service.deleteContact(contact.getName());
    }

    @Override
    public void export() {

        System.out.println("Exporting contact: " + contact.getName());
    }
}