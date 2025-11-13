package dev.ikute.jleetcode.easy;

/**
 * Max Consecutive Ones problem.
 *
 * @see <a href="https://leetcode.com/problems/max-consecutive-ones/">Max Consecutive Ones</a>
 */
public class MaxConsecutiveOnes {

    static int maxConsecutiveOnes(int[] nums) {
        int lhs = 0;
        int rhs = 0;
        int max = 0;

        for (; ; ) {
            if (rhs >= nums.length) {
                return max;
            }

            rhs += 1;
            if (nums[lhs] == 0) {
                lhs = rhs;
            }

            if (rhs == nums.length || nums[rhs] == 0) {
                max = Math.max(max, rhs - lhs);
                lhs = rhs;
            }
        }
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        return maxConsecutiveOnes(nums);
    }
}
