package dev.ikute.jleetcode.medium;

/**
 * Minimum Deletions to Make String Balanced problem.
 *
 * @see <a href="https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/">
 * Minimum Deletions to Make String Balanced
 * </a>
 */
public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {
        int dls = 0;
        int bcnt = 0;

        char[] str = s.toCharArray();
        for (char ch : str) {
            if (ch == 'b') {
                bcnt += 1;
            } else if (bcnt > 0) {
                dls += 1;
                bcnt -= 1;
            }
        }

        return dls;
    }
}
