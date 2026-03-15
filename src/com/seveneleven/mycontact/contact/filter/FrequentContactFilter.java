

/*
 * @author Developer
 * @version 10.0
 * 
 * 
 */
package com.seveneleven.mycontact.contact.filter;

import com.seveneleven.mycontact.contact.model.Contact;

public class FrequentContactFilter implements ContactFilter {

    private int threshold;

    public FrequentContactFilter(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean apply(Contact contact) {

        return contact.getContactCount() >= threshold;
    }
}