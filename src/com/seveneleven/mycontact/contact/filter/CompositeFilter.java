


/*
 * @author Developer
 * @version 10.0
 * 
 * 
 */

//more than one filter

package com.seveneleven.mycontact.contact.filter;

import java.util.ArrayList;
import java.util.List;

import com.seveneleven.mycontact.contact.model.Contact;

public class CompositeFilter implements ContactFilter {

    private List<ContactFilter> filters = new ArrayList<>();

    public void addFilter(ContactFilter filter) {
        filters.add(filter);
    }

    @Override
    public boolean apply(Contact contact) {

        for(ContactFilter f : filters) {
            if(!f.apply(contact))
                return false;
        }

        return true;
    }
}