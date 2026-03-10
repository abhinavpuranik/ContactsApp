
/*
 * @author Developer
 * @version 4.0
 * 
 */

//Person builder
package com.seveneleven.mycontact.contact.builder;
import java.util.ArrayList;
import java.util.List;

import com.seveneleven.mycontact.contact.model.EmailAddress;
import com.seveneleven.mycontact.contact.model.Person;
import com.seveneleven.mycontact.contact.model.PhoneNumber;
import com.seveneleven.mycontact.contact.model.Contact;
public class PersonContactBuilder implements ContactBuilder {

	private String name;
	private String company;
	
	private List<PhoneNumber> phones = new ArrayList<>();
	private List<EmailAddress> emails = new ArrayList<>();
	
	public PersonContactBuilder setCompany(String company) {
		this.company = company;
		return this;
	}
	
	@Override
	public ContactBuilder setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public ContactBuilder addPhone(PhoneNumber phone) {
	
		phones.add(phone);
	
		return this;
		
	}

	@Override
	public ContactBuilder addEmail(EmailAddress email) {
		emails.add(email);
		return this;
	}

	@Override
	public Contact build() {
		return new Person(name, phones, emails, company);
		
	
	}
	
}
