package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find All Anagrams in a String problem.
 *
 * @see <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams in a String</a>
 */
public class FindAllAnagramsInString {

    private static final int[] CHARBUF = new int[26];

    static List<Integer> findAllAnagram(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();

        for (int offset = 0; offset < s.length(); offset += 1) {
            if (isValidAnagram(s, offset, p)) {
                anagrams.add(offset);
            }
        }

        return anagrams;
    }

    static boolean isValidAnagram(String s, int offset, String p) {
        Arrays.fill(CHARBUF, 0);

        if (s.length() - offset < p.length()) {
            return false;
        }

        for (int idx = 0; idx < p.length(); idx += 1) {
            int ch = s.charAt(offset + idx) - 'a';
            CHARBUF[ch] += 1;
        }

        for (int idx = 0; idx < p.length(); idx += 1) {
            int ch = p.charAt(idx) - 'a';

            if (CHARBUF[ch] == 0) {
                return false;
            }

            CHARBUF[ch] -= 1;
        }

        for (int ch = 0; ch < CHARBUF.length; ch += 1) {
            if (CHARBUF[ch] != 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        return findAllAnagram(s, p);
    }
}
