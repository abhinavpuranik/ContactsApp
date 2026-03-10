package com.seveneleven.mycontact.contact.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class Contact {

    protected UUID id;
    protected String name;

    protected List<PhoneNumber> phoneNumbers;
    protected List<EmailAddress> emails;

    protected LocalDateTime createdAt;

    public Contact(String name,
                   List<PhoneNumber> phoneNumbers,
                   List<EmailAddress> emails) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}