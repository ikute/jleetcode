package dev.ikute.jleetcode.easy;

/**
 * Squares of a Sorted Array problem.
 *
 * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 */
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];

        int lhs = 0, rhs = nums.length - 1;
        int idx = nums.length - 1;
        for (; ; ) {
            if (idx < 0) {
                return squares;
            }

            int lsq = nums[lhs] * nums[lhs];
            int rsq = nums[rhs] * nums[rhs];
            if (lsq >= rsq) {
                squares[idx] = lsq;
                lhs += 1;
            } else {
                squares[idx] = rsq;
                rhs -= 1;
            }

            idx -= 1;
        }
    }
}
