package dev.ikute.jleetcode.easy;

/**
 * Longest Common Prefix problem.
 *
 * @see <a href="https://leetcode.com/problems/longest-common-prefix">Longest Common Prefix</a>
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        return longestCommonPrefix(new StringBuilder(200), 0, strs);
    }

    public String longestCommonPrefix(StringBuilder acc, int idx, String[] strs) {
        String fst = strs[0];
        if (fst.length() <= idx) {
            return acc.toString();
        }

        char prefix = fst.charAt(idx);
        for (String str : strs) {
            if (str.length() <= idx) {
                return acc.toString();
            }

            if (str.charAt(idx) != prefix) {
                return acc.toString();
            }
        }

        acc.append(prefix);
        return longestCommonPrefix(acc, idx + 1, strs);
    }
}
