/*
 * @author Developer
 * @version 5.0
 */


package com.seveneleven.mycontact.contact.view;
import com.seveneleven.mycontact.contact.model.*;

public class BasicContactView implements ContactView{

	private Contact contact;
	public BasicContactView(Contact contact) {
		this.contact = contact;
		
	}
	@Override
	public String display() {
		return "Contact ID: " + contact.getId() +
	               "\nName: " + contact.getName();
	}

}
