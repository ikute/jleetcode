package dev.ikute.jleetcode.easy;

/**
 * Reverse Bits problem.
 *
 * @see <a href="https://leetcode.com/problems/reverse-bits/">Reverse Bits</a>
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int rn = 0;
        for (int b = 0; b < 32; b++) {
            rn <<= 1;
            rn |= (n & 1);
            n >>>= 1;
        }

        return rn;
    }
}
