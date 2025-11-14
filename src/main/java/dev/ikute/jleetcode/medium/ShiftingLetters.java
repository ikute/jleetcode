package dev.ikute.jleetcode.medium;

/**
 * Shifting Letters problem.
 *
 * @see <a href="https://leetcode.com/problems/shifting-letters/">Shifting Letters</a>
 */
public class ShiftingLetters {

    static String shiftLetters(String s, int[] shifts) {
        long psum = 0;
        char[] str = new char[s.length()];

        for (int idx = s.length() - 1; idx >= 0; idx -= 1) {
            psum += shifts[idx];
            int ch = s.charAt(idx) - 'a';

            str[idx] = (char) ((ch + psum) % 26 + 'a');
        }

        return String.valueOf(str);
    }

    public String shiftingLetters(String s, int[] shifts) {
        return shiftLetters(s, shifts);
    }
}
