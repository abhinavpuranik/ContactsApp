package com.seveneleven.mycontact.contact.model;

import java.util.List;

public class Person extends Contact {

    private String company;

    public Person(String name,
                  List<PhoneNumber> phones,
                  List<EmailAddress> emails,
                  String company) {
        super(name, phones, emails);
        this.company = company;
    }

}