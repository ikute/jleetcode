package dev.ikute.jleetcode.medium;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters problem.
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        return lengthOfLongestSubstring(new LinkedHashSet<>(), 0, 0, s);
    }

    private static int lengthOfLongestSubstring(Set<Character> buf, int len, int offset, String s) {
        if (offset == s.length()) {
            return len;
        }

        char next = s.charAt(offset);
        boolean isUnique = buf.add(next);

        if (!isUnique) {
            Iterator<Character> iter = buf.iterator();

            for (; ; ) {
                char unique = iter.next();

                if (unique == next || !iter.hasNext()) {
                    iter.remove();
                    break;
                }

                iter.remove();
            }

            buf.add(next);

            return lengthOfLongestSubstring(buf, Math.max(len, buf.size()), offset + 1, s);
        }

        return lengthOfLongestSubstring(buf, Math.max(len, buf.size()), offset + 1, s);
    }
}
