package com.interview;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * [3:07 PM] Karansing Vilas Rajput
 * Given a string text, you want to use the characters of text to form as many instances
 * of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * <p>
 * <p>
 * Example: nlaebolko --> balloon
 * Ans: 1
 */
public class Test {

    /**
     * baqwweeeertylln -> 0
     * nlaebolko -> 1
     * loonbalxballpoon -> 2
     * rishabh -> 0
     */
    public static void main(String[] args) {
        String textToForm = "balloon";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : textToForm.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Arrays.asList(
                "nlaebolko",    // 1
                "balloonballoonballon", // 2
                "baqwweeeertylln", // 0
                "loonbalxballpoon" // 2
            )
            .forEach(word -> {
                System.out.printf("Word: %s, numberOfInstances: %s\n", word, balloonInstances(word, map));
            });
    }


    /**
     * @param s
     * @param wordToForm
     * @return
     */
    public static int balloonInstances(final String s, final Map<Character, Integer> wordToForm) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        AtomicInteger wordsPossible = new AtomicInteger(-1);
        wordToForm.forEach((key, value) -> {
            Integer charFrequency = map.get(key);
            if (charFrequency == null) {
                wordsPossible.set(0);
                return;
            }
            int possibleWordsByCurrentChar = charFrequency / value;
            if (wordsPossible.get() == -1 || possibleWordsByCurrentChar < wordsPossible.get()) {
                wordsPossible.set(possibleWordsByCurrentChar);
            }
        });
        return wordsPossible.get();
    }

}
