package com.seveneleven.mycontact.contact.model;

import java.util.List;

public class Organization extends Contact {

    private String website;

    public Organization(String name,
                        List<PhoneNumber> phones,
                        List<EmailAddress> emails,
                        String website) {

        super(name, phones, emails);
        this.website = website;
    }
}