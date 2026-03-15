/*
 * @author Developer
 * @version 9.0
 * 
 * 
 */

package com.seveneleven.mycontact.contact.search.specification;

import java.util.regex.Pattern;

import com.seveneleven.mycontact.contact.model.Contact;

public class PhoneCriteria implements SearchCriteria {

    private Pattern pattern;

    public PhoneCriteria(String phonePattern) {
        this.pattern = Pattern.compile(phonePattern);
    }

    @Override
    public boolean matches(Contact contact) {

        return contact.getPhoneNumbers()
                .stream()
                .anyMatch(p ->
                        pattern.matcher(p.getNumber()).find());
    }
}