package dev.ikute.jleetcode.easy;

/**
 * Counting Bits problem.
 *
 * @see <a href="https://leetcode.com/problems/counting-bits/">Counting Bits</a>
 */
public class CountingBits {

    static int bits(int n) {
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

    static int[] bitsn(int n) {
        int[] bits = new int[n + 1];
        for (int k = 0; k <= n; k += 1) {
            bits[k] = bits(k);
        }

        return bits;
    }

    public int[] countBits(int n) {
        return bitsn(n);
    }
}
