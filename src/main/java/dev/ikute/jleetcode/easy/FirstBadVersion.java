package dev.ikute.jleetcode.easy;

/**
 * First Bad Version problem.
 *
 * @see <a href="https://leetcode.com/problems/first-bad-version/">First Bad Version</a>
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        return searchForFirst(1, n);
    }

    int searchForFirst(int lhs, int rhs) {
        if (lhs == rhs) {
            return lhs;
        }

        int mid = lhs + (rhs - lhs) / 2;

        if (super.isBadVersion(mid)) {
            return searchForFirst(lhs, mid);
        } else {
            return searchForFirst(mid + 1, rhs);
        }
    }
}

abstract class VersionControl {

    public boolean isBadVersion(int version) {
        /// impl...
        return false;
    }
}
