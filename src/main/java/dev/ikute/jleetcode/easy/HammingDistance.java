package dev.ikute.jleetcode.easy;

/**
 * Hamming Distance problem.
 *
 * @see <a href="https://leetcode.com/problems/hamming-distance/">Hamming Distance</a>
 */
public class HammingDistance {

    static int countBits(int n) {
        int count = 0;
        for (; ; ) {
            if (n <= 0) {
                break;
            }

            n &= (n - 1);
            count += 1;
        }

        return count;
    }

    public int hammingDistance(int x, int y) {
        return countBits(x ^ y);
    }
}
