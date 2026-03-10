/*
 * @author Developer
 * @version 5.0
 * abstract decorator class
 */


package com.seveneleven.mycontact.contact.view.decorator;
import com.seveneleven.mycontact.contact.view.ContactView;

public abstract class ContactViewDecorator implements ContactView{
	
	protected ContactView view;
	public ContactViewDecorator(ContactView view) {
		this.view = view;
	}

}
