/*
 * @author Developer
 * @version 4.0
 * 
 */
//Factory pattern for creating contacts

package com.seveneleven.mycontact.contact.factory;

import java.util.List;

import com.seveneleven.mycontact.contact.builder.OrganizationContactBuilder;
import com.seveneleven.mycontact.contact.builder.PersonContactBuilder;
import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.model.EmailAddress;
import com.seveneleven.mycontact.contact.model.PhoneNumber;

public class ContactFactory {

	public static Contact createContact(
	        String type,
	        String name,
	        List<String> phones,
	        List<String> emails
	) {

	    if(type.equalsIgnoreCase("PERSON")) {
	        PersonContactBuilder builder = new PersonContactBuilder();
	        builder.setName(name);

	        phones.forEach(p -> builder.addPhone(new PhoneNumber(p)));
	        emails.forEach(e -> builder.addEmail(new EmailAddress(e)));

	        return builder.build();
	    }

	    if(type.equalsIgnoreCase("ORG")) {
	        OrganizationContactBuilder builder = new OrganizationContactBuilder();
	        builder.setName(name);

	        phones.forEach(p -> builder.addPhone(new PhoneNumber(p)));
	        emails.forEach(e -> builder.addEmail(new EmailAddress(e)));

	        return builder.build();
	    }

	    throw new IllegalArgumentException("Invalid contact type");
	}
}