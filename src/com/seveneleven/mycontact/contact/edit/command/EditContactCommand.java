
/*
 * @author Developer
 * @version 6.0
 * 
 */

//editing with state saving
package com.seveneleven.mycontact.contact.edit.command;

import com.seveneleven.mycontact.contact.edit.memento.ContactMemento;
import com.seveneleven.mycontact.contact.model.Contact;

public class EditContactCommand {

    private Contact contact;
    private String newName;

    private ContactMemento backup;

    public EditContactCommand(Contact contact, String newName) {
        this.contact = contact;
        this.newName = newName;
    }

    public void execute() {

        // save state before change
        backup = contact.saveState();

        contact.setName(newName);

        System.out.println("Contact updated successfully");
    }

    public void undo() {

        if(backup != null) {
            contact.restoreState(backup);
            System.out.println("Undo successful");
        }
    }
}