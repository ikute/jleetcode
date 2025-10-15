package dev.ikute.jleetcode.easy;

/**
 * Sqrt(x) problem.
 *
 * @see <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int lhs = 2;
        int rhs = Math.min(x / 2, 46340);

        for (; ; ) {
            if (lhs >= rhs) {
                return lhs * lhs > x ? lhs - 1 : lhs;
            }

            int mid = lhs + (rhs - lhs) / 2;
            int n = mid * mid;
            if (n == x) {
                return mid;
            }

            if (x < n) {
                rhs = mid - 1;
            } else {
                lhs = mid + 1;
            }
        }
    }
}
