
/*
 * @author developer
 * @version 8.0
 * component interface
 * For multiple contacts
 */


package com.seveneleven.mycontact.contact.bulk;

import java.util.ArrayList;
import java.util.List;

public class ContactGroup implements ContactComponent {

    private List<ContactComponent> components = new ArrayList<>();

    public void add(ContactComponent component) {
        components.add(component);
    }

    public void remove(ContactComponent component) {
        components.remove(component);
    }

    @Override
    public void delete() {

        for(ContactComponent c : components) {
            c.delete();
        }
    }

    @Override
    public void export() {

        for(ContactComponent c : components) {
            c.export();
        }
    }
}