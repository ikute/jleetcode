package dev.ikute.jleetcode.medium;

/**
 * Count Number of Nice Subarrays problem.
 *
 * @see <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/">Count Number of Nice Subarrays</a>
 */
public class CountNumberOfNiceSubarrays {

    static int countOddSubarrays(int[] nums, int k) {
        int lhs = 0, rhs = 0;
        int odd = 0;
        int cnt = 0, cntl = 0;

        for (; ; ) {
            if (rhs >= nums.length) {
                return cnt;
            }

            if ((nums[rhs] & 1) != 0) {
                odd += 1;

                if (odd >= k) {
                    cntl = 1;

                    while ((nums[lhs] & 1) == 0) {
                        cntl += 1;
                        lhs += 1;
                    }

                    lhs += 1;
                    cnt += cntl;
                }
            } else if (odd >= k) {
                cnt += cntl;
            }

            rhs += 1;
        }
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return countOddSubarrays(nums, k);
    }
}
