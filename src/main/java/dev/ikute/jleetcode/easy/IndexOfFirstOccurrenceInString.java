package dev.ikute.jleetcode.easy;

/**
 * Find the Index of the First Occurrence in a String problem.
 *
 * @see <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string">Find the Index of the First Occurrence in a String</a>
 */
public class IndexOfFirstOccurrenceInString {

    public int strStr(String haystack, String needle) {
        return strStrRecursive(0, haystack, needle);
    }

    private static int strStrRecursive(int offset, String haystack, String needle) {
        int idx = 0;
        for (; ; ) {
            if (offset + idx == haystack.length()) {
                return -1;
            }

            char ch = haystack.charAt(offset + idx);
            char cn = needle.charAt(idx);

            if (ch != cn) {
                break;
            }

            idx += 1;
            if (idx == needle.length()) {
                return offset;
            }
        }

        return strStrRecursive(offset + 1, haystack, needle);
    }
}
