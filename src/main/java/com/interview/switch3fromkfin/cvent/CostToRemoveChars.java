package com.interview.switch3fromkfin.cvent;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a string s. We need to remove min characters in such a way that frequency of characters
 * becomes unique.
 * For example, String s = aabbbcddeeeee
 * a = 2
 * b = 3
 * c = 1
 * d = 2
 * e = 5
 * <p>
 * if we remove either both a or both d then we'll end up as follows, (assume removing both a)
 * b = 3, c = 1, d = 2, e = 5 ==> this way we will get frequency of each character as unique.
 * Hence, answer is 2.
 * <p>
 * Assume another example,
 * a = 2
 * c = 4
 * d = 4
 * <p>
 * In this case if we remove either one c or one d (assume remove one c) we'll end up as follows,
 * a = 2, c = 3, d = 4 ==> this way also we ended up having unique frequency
 * Hence answer is 1.
 */
public class CostToRemoveChars {

    public static void main(String[] args) {
        Stream.of("aabbbcddeeeee", "aaccccdddd", "ab", "aaabbbccc", "aaaabbbbcccccdddddd", "a", "a&")
            .forEach(input -> {
                Long[] characterWiseFrequency = Stream.of(input.split(""))
                    .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()))
                    .values().toArray(new Long[0]);

                AtomicLong charactersToRemove = new AtomicLong(0);
                while (hasMoreElements(characterWiseFrequency, charactersToRemove)) {
                    // nothing here.
                }
                System.out.println(input + ", " + charactersToRemove);
            });
    }

    static boolean hasMoreElements(Long[] characterWiseFrequency, AtomicLong charsToRemove) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < characterWiseFrequency.length; i++) {
            long element = characterWiseFrequency[i];
            if (element == 0L) {
                continue;
            }
            if (set.contains(element)) {
                if (element == 1L) {
                    charsToRemove.incrementAndGet();
                    characterWiseFrequency[i] = 0L;
                } else {
                    for (long j = element - 1; j >= 1; j--) {
                        if (!set.contains(j)) {
                            set.add(j);
                            characterWiseFrequency[i] = element - j;
                            charsToRemove.addAndGet(characterWiseFrequency[i]);
                            break;
                        }
                        characterWiseFrequency[i] = 0L;
                        charsToRemove.addAndGet(element);
                    }
                }
                return true;
            }
            set.add(element);
        }
        return false;
    }

}
