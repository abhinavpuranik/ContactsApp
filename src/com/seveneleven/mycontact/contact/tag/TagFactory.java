
/*
 * @author Developer
 * @version 11.0
 * 
 * 
 */

package com.seveneleven.mycontact.contact.tag;

import java.util.HashMap;
import java.util.Map;

public class TagFactory {

    private static final Map<String, Tag> tagPool = new HashMap<>();

    public static Tag getTag(String name) {

        String key = name.toLowerCase();

        if(!tagPool.containsKey(key)) {
            tagPool.put(key, new Tag(key));
        }

        return tagPool.get(key);
    }
}