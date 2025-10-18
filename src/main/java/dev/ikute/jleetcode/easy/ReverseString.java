package dev.ikute.jleetcode.easy;

/**
 * Reverse String problem.
 *
 * @see <a href="https://leetcode.com/problems/reverse-string/">Reverse String</a>
 */
public class ReverseString {

    static void reverse(char[] s) {
        int lhs = 0;
        int rhs = s.length - 1;

        for (; ; ) {
            if (lhs >= rhs) {
                break;
            }

            swap(s, lhs, rhs);
            lhs += 1;
            rhs -= 1;
        }
    }

    static void swap(char[] p, int lhs, int rhs) {
        p[lhs] ^= p[rhs];
        p[rhs] ^= p[lhs];
        p[lhs] ^= p[rhs];
    }

    public void reverseString(char[] s) {
        reverse(s);
    }
}
