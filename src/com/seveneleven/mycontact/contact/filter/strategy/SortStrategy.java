

/*
 * @author Developer
 * @version 10.0
 * 
 * 
 */

//sorting strategy interface
package com.seveneleven.mycontact.contact.filter.strategy;

import java.util.Comparator;

import com.seveneleven.mycontact.contact.model.Contact;

public interface SortStrategy {

    Comparator<Contact> getComparator();

}