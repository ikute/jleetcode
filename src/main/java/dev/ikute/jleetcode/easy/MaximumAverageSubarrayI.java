package dev.ikute.jleetcode.easy;

/**
 * Maximum Average Subarray I problem.
 *
 * @see <a href="https://leetcode.com/problems/maximum-average-subarray-i/">Maximum Average Subarray I</a>
 */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        System.out.println(maxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    static double maxAverage(int[] nums, int k) {
        if (k > nums.length) {
            return 0.0;
        }

        int sum = 0;
        for (int idx = 0; idx < k; idx += 1) {
            sum += nums[idx];
        }

        int msum = sum;
        for (int idx = k; idx < nums.length; idx += 1) {
            sum = sum - nums[idx - k] + nums[idx];
            msum = Math.max(sum, msum);
        }

        return ((double) msum) / ((double) k);
    }

    public double findMaxAverage(int[] nums, int k) {
        return maxAverage(nums, k);
    }
}
