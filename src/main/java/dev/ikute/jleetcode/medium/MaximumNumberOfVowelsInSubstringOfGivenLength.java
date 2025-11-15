package dev.ikute.jleetcode.medium;

import java.util.Set;

/**
 * Maximum Number of Vowels in a Substring of Given Length problem.
 *
 * @see <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">
 * Maximum Number of Vowels in a Substring of Given Length
 * </a>
 */
public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int len = 0;
        for (int idx = 0; idx < k; idx += 1) {
            char ch = s.charAt(idx);

            if (VOWELS.contains(ch)) {
                len += 1;
            }
        }

        int mlen = len;
        for (int idx = k; idx < s.length(); idx += 1) {
            char rch = s.charAt(idx);
            char lch = s.charAt(idx - k);

            if (VOWELS.contains(rch)) {
                len += 1;
            }

            if (VOWELS.contains(lch)) {
                len -= 1;
            }

            mlen = Math.max(mlen, len);
        }

        return mlen;
    }
}
