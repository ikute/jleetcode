package dev.ikute.jleetcode.easy;

/**
 * Valid Anagram problem.
 *
 * @see <a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram</a>
 */
public class ValidAnagram {

    static boolean isValidAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] chbuf = new int[26];

        for (int idx = 0; idx < s.length(); idx += 1) {
            int ch = s.charAt(idx) - 'a';
            chbuf[ch] += 1;
        }

        for (int idx = 0; idx < t.length(); idx += 1) {
            int ch = t.charAt(idx) - 'a';

            if (chbuf[ch] == 0) {
                return false;
            }

            chbuf[ch] -= 1;
        }

        for (int ch = 0; ch < chbuf.length; ch += 1) {
            if (chbuf[ch] != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        return isValidAnagram(s, t);
    }
}
