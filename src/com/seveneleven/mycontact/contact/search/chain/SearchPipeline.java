/*
 * @author Developer
 * @version 9.0
 * 
 * 
 */

package com.seveneleven.mycontact.contact.search.chain;

import java.util.List;

import com.seveneleven.mycontact.contact.model.Contact;

public class SearchPipeline {

    private FilterHandler head;

    public void addFilter(FilterHandler handler) {

        if(head == null) {
            head = handler;
            return;
        }

        FilterHandler current = head;

        while(current.setNext(null) != null) {
            current = current.setNext(null);
        }

        current.setNext(handler);
    }

    public List<Contact> execute(List<Contact> contacts) {

        if(head == null)
            return contacts;

        return head.handle(contacts);
    }
}