
/*
 * @author Developer
 * @version 9.0
 * 
 * 
 */
//Basic search interface

package com.seveneleven.mycontact.contact.search.specification;

import com.seveneleven.mycontact.contact.model.Contact;

public interface SearchCriteria {

    boolean matches(Contact contact);

}