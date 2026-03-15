/*
 * @author Developer
 * @version 9.0
 * 
 * 
 */

package com.seveneleven.mycontact.contact.search.specification;

import com.seveneleven.mycontact.contact.model.Contact;

public class EmailCriteria implements SearchCriteria {

    private String email;

    public EmailCriteria(String email) {
        this.email = email.toLowerCase();
    }

    @Override
    public boolean matches(Contact contact) {

        return contact.getEmails()
                .stream()
                .anyMatch(e ->
                        e.getEmail()
                         .toLowerCase()
                         .contains(email));
    }
}