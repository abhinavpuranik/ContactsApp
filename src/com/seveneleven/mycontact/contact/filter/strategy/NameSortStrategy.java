
/*
 * @author Developer
 * @version 10.0
 * 
 * 
 */
package com.seveneleven.mycontact.contact.filter.strategy;

import java.util.Comparator;

import com.seveneleven.mycontact.contact.model.Contact;

public class NameSortStrategy implements SortStrategy {

    @Override
    public Comparator<Contact> getComparator() {

        return Comparator.comparing(Contact::getName);
    }
}