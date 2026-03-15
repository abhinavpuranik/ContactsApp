/*
 * @author Developer
 * @version 12.0
 * 
 * Tag observer interface
 */

package com.seveneleven.mycontact.contact.tagging.observer;

import com.seveneleven.mycontact.contact.model.Contact;
import com.seveneleven.mycontact.contact.tag.Tag;

public interface TagObserver {

    void onTagAdded(Contact contact, Tag tag);

    void onTagRemoved(Contact contact, Tag tag);
}