package dev.ikute.jleetcode.medium;

/**
 * String Compression problem.
 *
 * @see <a href="https://leetcode.com/problems/string-compression/">String Compression</a>
 */
public class StringCompression {

    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }

        char ch = chars[0];
        int rlen = 1;
        int len = 1;

        for (int idx = 1; idx < chars.length; idx += 1) {
            if (chars[idx] == ch) {
                rlen += 1;
                continue;
            }

            if (rlen > 1) {
                char[] digits = String.valueOf(rlen).toCharArray();
                for (char digit : digits) {
                    chars[len] = digit;
                    len += 1;
                }
            }

            ch = chars[idx];
            chars[len] = ch;
            len += 1;
            rlen = 1;
        }

        if (rlen > 1) {
            char[] digits = String.valueOf(rlen).toCharArray();
            for (char digit : digits) {
                chars[len] = digit;
                len += 1;
            }
        }

        return len;
    }
}
