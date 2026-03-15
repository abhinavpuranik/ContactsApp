
/*
 * @author Developer
 * @version 12.0
 * 
 * 
 */


package com.seveneleven.mycontact.contact.tagging.service;

import java.util.ArrayList;
import java.util.List;

import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.tag.Tag;
import com.seveneleven.mycontact.contact.tagging.observer.TagObserver;

public class TaggingService {

    private List<TagObserver> observers = new ArrayList<>();

    public void addObserver(TagObserver observer) {
        observers.add(observer);
    }

    private void notifyTagAdded(Contact contact, Tag tag) {

        for(TagObserver o : observers) {
            o.onTagAdded(contact, tag);
        }
    }

    private void notifyTagRemoved(Contact contact, Tag tag) {

        for(TagObserver o : observers) {
            o.onTagRemoved(contact, tag);
        }
    }

    public void addTagToContact(Contact contact, Tag tag) {

        contact.addTag(tag);

        notifyTagAdded(contact, tag);
    }

    public void removeTagFromContact(Contact contact, Tag tag) {

        contact.removeTag(tag);

        notifyTagRemoved(contact, tag);
    }
}