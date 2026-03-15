
/*
 * @author Developer
 * @version 11.0
 * 
 * 
 */

//Proper tag object
package com.seveneleven.mycontact.contact.tag;

import java.util.Objects;

public class Tag {

    private final String name;

    public Tag(String name) {

        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Tag cannot be empty");

        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;
        if(!(obj instanceof Tag)) return false;

        Tag other = (Tag) obj;

        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

//	public String toLowerCase() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}