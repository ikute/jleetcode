package dev.ikute.jleetcode.easy;

/**
 * Power of Two problem.
 *
 * @see <a href="https://leetcode.com/problems/power-of-two/">Power of Two</a>
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
