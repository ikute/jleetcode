package dev.ikute.jleetcode.medium;

/**
 * Longest Palindromic Substring problem.
 *
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring">Longest Palindromic Substring</a>
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String string) {
        return findLongestPalindrome(string);
    }

    private static String findLongestPalindrome(String string) {
        if (string.length() <= 1) {
            return string;
        }

        int len = string.length();
        byte[] equality = new byte[len * len];

        for (int row = 0; row < len; row += 1) {
            for (int col = row; col < len; col += 1) {
                if (equality[row + col * len] == 1) {
                    continue;
                }

                if (string.charAt(row) == string.charAt(col)) {
                    equality[row + col * len] = 1;
                    equality[col + row * len] = 1;
                }
            }
        }

        int mstart = 0, mend = 0;

        for (int diag = 0; diag < len; diag += 1) {
            int row = diag, col = 0;
            for (; row >= 0 && col <= diag; row -= 1, col += 1) {
                if (equality[row + col * len] == 1) {
                    int start = col, end = row;
                    for (; (row >= 0 && col <= diag) && (equality[row + col * len] == 1); row -= 1, col += 1) {
                    }

                    if (start != row + 1 || end != col - 1) {
                        continue;
                    }

                    if (end - start > mend - mstart) {
                        mstart = start;
                        mend = end;
                    }
                }
            }
        }

        for (int diag = 1; diag < len; diag += 1) {
            int row = len - 1, col = diag;
            for (; row >= diag && col <= len; row -= 1, col += 1) {
                if (equality[row + col * len] == 1) {
                    int start = col, end = row;
                    for (; (row >= diag && col <= len) && (equality[row + col * len] == 1); row -= 1, col += 1) {
                    }

                    if (start != row + 1 || end != col - 1) {
                        continue;
                    }

                    if (end - start > mend - mstart) {
                        mstart = start;
                        mend = end;
                    }
                }
            }
        }

        return string.substring(mstart, mend + 1);
    }
}
