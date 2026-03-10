/*
 * @author Developer
 * @version 4.0
 * 
 */

//builder pattern for contact

package com.seveneleven.mycontact.contact.builder;
import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.model.EmailAddress;
import com.seveneleven.mycontact.contact.model.PhoneNumber;
public interface ContactBuilder {

		ContactBuilder setName(String name);
		ContactBuilder addPhone(PhoneNumber phone);
		ContactBuilder addEmail(EmailAddress email);
		
		Contact build();
}
