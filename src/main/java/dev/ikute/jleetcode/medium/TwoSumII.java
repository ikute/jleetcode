package dev.ikute.jleetcode.medium;

/**
 * Two Sum II - Input Array Is Sorted problem.
 *
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II</a>
 */
public class TwoSumII {

    static int[] findTwoSumIndices(int[] p, int target) {
        if (p.length <= 2) {
            return new int[]{1, 2};
        }

        int lhs = 0;
        int rhs = p.length - 1;

        for (; ; ) {
            if (lhs >= rhs) {
                return new int[]{0, 0};
            }

            int sum = p[lhs] + p[rhs];

            if (sum == target) {
                return new int[]{lhs + 1, rhs + 1};
            }

            if (sum < target) {
                lhs += 1;
            } else {
                rhs -= 1;
            }
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        return findTwoSumIndices(numbers, target);
    }
}
