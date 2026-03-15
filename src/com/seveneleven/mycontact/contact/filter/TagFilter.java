
/*
 * @author Developer
 * @version 10.0
 * 
 * 
 */
package com.seveneleven.mycontact.contact.filter;

import com.seveneleven.mycontact.contact.model.Contact;

public class TagFilter implements ContactFilter {

    private String tag;

    public TagFilter(String tag) {
        this.tag = tag.toLowerCase();
    }

    @Override
    public boolean apply(Contact contact) {

        return contact.getTags()
                .stream()
                .anyMatch(t -> t.equalsIgnoreCase(tag));
    }
}