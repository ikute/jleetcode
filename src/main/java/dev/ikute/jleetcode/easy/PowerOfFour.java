package dev.ikute.jleetcode.easy;

/**
 * Power of Four problem.
 *
 * @see <a href="https://leetcode.com/problems/power-of-four/">Power of Four</a>
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        return ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}
