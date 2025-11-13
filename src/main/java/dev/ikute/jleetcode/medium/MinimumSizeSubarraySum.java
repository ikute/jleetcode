package dev.ikute.jleetcode.medium;

/**
 * Minimum Size Subarray Sum problem.
 *
 * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray Sum</a>
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{1, 2, 3, 4, 5}, 15));
    }

    static int minSubarray(int[] nums, int target) {
        int lhs = 0;
        int rhs = 0;
        int sum = 0;
        int mlen = Integer.MAX_VALUE;

        for (; ; ) {
            if (rhs >= nums.length) {
                break;
            }

            for (; ; ) {
                if (sum >= target) {
                    break;
                }

                if (rhs >= nums.length) {
                    break;
                }

                sum += nums[rhs];
                rhs += 1;
            }

            if (sum >= target) {
                for (; ; ) {
                    if (sum < target) {
                        mlen = Math.min(rhs - lhs + 1, mlen);
                        break;
                    }

                    if (lhs >= rhs) {
                        break;
                    }

                    sum -= nums[lhs];
                    lhs += 1;
                }
            }
        }

        return mlen < Integer.MAX_VALUE ? mlen : 0;
    }

    public int minSubArrayLen(int target, int[] nums) {
        return minSubarray(nums, target);
    }
}
