/*
 * @author Developer
 * @version 9.0
 * 
 * 
 */

package com.seveneleven.mycontact.contact.search.specification;

import com.seveneleven.mycontact.contact.model.Contact;

public class TagCriteria implements SearchCriteria {

    private String tag;

    public TagCriteria(String tag) {
        this.tag = tag.toLowerCase();
    }

    @Override
    public boolean matches(Contact contact) {

        if(contact.getTags() == null)
            return false;

        return contact.getTags()
                .stream()
                .anyMatch(t -> t.toLowerCase().contains(tag));
    }
}