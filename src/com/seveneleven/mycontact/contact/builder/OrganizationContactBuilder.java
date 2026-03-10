/*
 * @author Developer
 * @version 4.0
 * 
 */
//Organization builder

package com.seveneleven.mycontact.contact.builder;
import java.util.ArrayList;
import java.util.List;

import com.seveneleven.mycontact.contact.model.EmailAddress;
import com.seveneleven.mycontact.contact.model.Organization;

import com.seveneleven.mycontact.contact.model.PhoneNumber;
import com.seveneleven.mycontact.contact.model.Contact;
public class OrganizationContactBuilder implements ContactBuilder {

	private String name;
	private String website;
	
	private List<PhoneNumber> phones = new ArrayList<>();
	private List<EmailAddress> emails = new ArrayList<>();
	
	public OrganizationContactBuilder setCompany(String website) {
		this.website = website;
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
		return new Organization(name, phones, emails, website);
		
	
	}
	
}
