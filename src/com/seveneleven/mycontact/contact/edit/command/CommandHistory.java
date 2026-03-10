/*
 * @author Developer
 * @version 6.0
 * 
 */

//undoing history stack

package com.seveneleven.mycontact.contact.edit.command;

import java.util.Stack;

public class CommandHistory {

    private Stack<EditContactCommand> history = new Stack<>();

    public void execute(EditContactCommand command) {

        command.execute();
        history.push(command);
    }

    public void undo() {

        if(!history.isEmpty()) {
            history.pop().undo();
        }
    }
}