/*
 * @author Developer
 * @version 5.0
 * 
 * email address decorator
 */


package com.seveneleven.mycontact.contact.view.decorator;

import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.model.EmailAddress;
import com.seveneleven.mycontact.contact.view.ContactView;

public class EmailDisplayDecorator extends ContactViewDecorator {

    private Contact contact;

    public EmailDisplayDecorator(ContactView view, Contact contact) {
        super(view);
        this.contact = contact;
    }

    @Override
    public String display() {

        StringBuilder builder = new StringBuilder(view.display());

        builder.append("\nEmails:");

        for(EmailAddress e : contact.getEmails()) {
            builder.append("\n - ").append(e.getEmail());
        }

        return builder.toString();
    }
}