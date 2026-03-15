
/*
 * @author Developer
 * @version 10.0
 * 
 * 
 */

package com.seveneleven.mycontact.contact.filter;

import java.time.LocalDateTime;

import com.seveneleven.mycontact.contact.model.Contact;

public class DateAddedFilter implements ContactFilter {

    private LocalDateTime afterDate;

    public DateAddedFilter(LocalDateTime afterDate) {
        this.afterDate = afterDate;
    }

    @Override
    public boolean apply(Contact contact) {

        return contact.getCreatedAt().isAfter(afterDate);
    }
}