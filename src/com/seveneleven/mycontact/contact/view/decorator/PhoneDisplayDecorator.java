/*
 * @author Developer
 * @version 5.0
 * 
 * phone number decorator
 */


package com.seveneleven.mycontact.contact.view.decorator;

import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.model.PhoneNumber;
import com.seveneleven.mycontact.contact.view.ContactView;

public class PhoneDisplayDecorator extends ContactViewDecorator {

	private Contact contact;
	public PhoneDisplayDecorator(ContactView view, Contact contact) {
		super(view);
		this.contact = contact;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String display() {
		StringBuilder builder = new StringBuilder(view.display());
		builder.append("Phone number: ");
		
		for(PhoneNumber p : contact.getPhoneNumbers()) {
            builder.append("\n - ").append(p.getNumber());
        }

        return builder.toString();
	}

}
