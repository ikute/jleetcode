package dev.ikute.jleetcode.medium;

/**
 * Longest Repeating Character Replacement problem.
 *
 * @see <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">
 * Longest Repeating Character Replacement
 * </a>
 */
public class LongestRepeatingCharacterReplacement {

    static int replace(String s, int k) {
        int rcnt = 0;
        int rlen = 0;
        int[] chbuf = new int[26];

        int lhs = 0;
        int rhs = 0;
        for (; ; ) {
            if (rhs >= s.length()) {
                return rlen;
            }

            int rch = s.charAt(rhs) - 'A';

            chbuf[rch] += 1;
            rcnt = Math.max(rcnt, chbuf[rch]);
            rhs += 1;

            if ((rhs - lhs) - rcnt > k) {
                int lch = s.charAt(lhs) - 'A';

                chbuf[lch] -= 1;
                lhs += 1;
            }

            rlen = Math.max(rlen, rhs - lhs);
        }
    }

    public int characterReplacement(String s, int k) {
        return replace(s, k);
    }
}
