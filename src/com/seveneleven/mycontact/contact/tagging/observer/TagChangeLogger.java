/*
 * @author Developer
 * @version 12.0
 * 
 * 
 */


package com.seveneleven.mycontact.contact.tagging.observer;

import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.tag.Tag;

public class TagChangeLogger implements TagObserver {

    @Override
    public void onTagAdded(Contact contact, Tag tag) {
        System.out.println("Tag '" + tag.getName() +
                "' added to contact " + contact.getName());
    }

    @Override
    public void onTagRemoved(Contact contact, Tag tag) {
        System.out.println("Tag '" + tag.getName() +
                "' removed from contact " + contact.getName());
    }
}