package dev.ikute.jleetcode.medium;

/**
 * Total Hamming Distance problem.
 *
 * @see <a href="https://leetcode.com/problems/total-hamming-distance/">Total Hamming Distance</a>
 */
public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int total = 0;

        for (int b = 0; b < 32; b += 1) {
            int bitsCount = 0;
            for (int num : nums) {
                bitsCount += (num >> b) & 1;
            }

            total += bitsCount * (nums.length - bitsCount);
        }

        return total;
    }
}
