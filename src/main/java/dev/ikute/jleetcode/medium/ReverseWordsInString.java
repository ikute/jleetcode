package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse Words in a String problem.
 *
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Reverse Words in a String</a>
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        List<String> reversed = new ArrayList<>(s.length());

        int idx = s.length() - 1;
        for (; ; ) {
            if (idx < 0) {
                return String.join(" ", reversed);
            }

            if (s.charAt(idx) == ' ') {
                idx -= 1;
            } else {
                int rhs = idx, lhs = idx;
                while (lhs >= 0 && s.charAt(lhs) != ' ') {
                    lhs -= 1;
                }

                reversed.add(s.substring(lhs + 1, rhs + 1));
                idx = lhs - 1;
            }
        }
    }
}
