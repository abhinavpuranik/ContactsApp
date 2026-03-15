/*
 * @author Developer
 * @version 10.0
 * 
 * 
 */

//filter interface


package com.seveneleven.mycontact.contact.filter;

import com.seveneleven.mycontact.contact.model.Contact;

public interface ContactFilter {

    boolean apply(Contact contact);

}