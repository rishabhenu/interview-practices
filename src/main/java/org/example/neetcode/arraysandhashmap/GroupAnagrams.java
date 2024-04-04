package org.example.neetcode.arraysandhashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupAnagrams {

    public static void main(String[] args) {
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (String str : strs) {
            String signature = makeCustomHash(str);
            stringListMap.putIfAbsent(signature, new ArrayList<>());
            stringListMap.get(signature).add(str);
        }
        return new ArrayList<>(stringListMap.values());
    }

    public static String makeCustomHash(final String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c: s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((key, val) -> stringBuilder.append(key).append(val));
        return stringBuilder.toString();
    }

}
