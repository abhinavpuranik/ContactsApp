

/*
 * @author Developer
 * @version 9.0
 * 
 * 
 */
package com.seveneleven.mycontact.contact.search.specification;

import com.seveneleven.mycontact.contact.model.Contact;

public class NameCriteria implements SearchCriteria {

    private String name;

    public NameCriteria(String name) {
        this.name = name.toLowerCase();
    }

    @Override
    public boolean matches(Contact contact) {

        return contact.getName()
                .toLowerCase()
                .contains(name);
    }
}