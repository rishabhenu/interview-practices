package org.example.neetcode.arraysandhashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagramString {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        int[] count = new int[26];
        for (int i = 0; i < schars.length; i++) {
            count[schars[i] - 'a'] += 1;
            count[tchars[i] - 'a'] -= 1;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
