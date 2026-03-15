/*
 * @author Developer
 * @version 9.0
 * 
 * 
 */

//Chain of responsibility

package com.seveneleven.mycontact.contact.search.chain;

import java.util.List;
import java.util.stream.Collectors;

import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.search.specification.SearchCriteria;

public class FilterHandler {

    private SearchCriteria criteria;
    private FilterHandler next;

    public FilterHandler(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    public FilterHandler setNext(FilterHandler next) {
        this.next = next;
        return next;
    }

    public List<Contact> handle(List<Contact> contacts) {

        List<Contact> filtered =
                contacts.stream()
                        .filter(criteria::matches)
                        .collect(Collectors.toList());

        if(next == null)
            return filtered;

        return next.handle(filtered);
    }
}