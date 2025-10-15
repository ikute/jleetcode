package dev.ikute.jleetcode.easy;

/**
 * Search Insert Position problem.
 *
 * @see <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int lhs = 0;
        int rhs = nums.length - 1;

        for (; ; ) {
            if (lhs >= rhs) {
                return target > nums[lhs] ? lhs + 1 : lhs;
            }

            int mid = lhs + (rhs - lhs) / 2;
            int n = nums[mid];

            if (n == target) {
                return mid;
            }

            if (target < n) {
                rhs = mid - 1;
            } else {
                lhs = mid + 1;
            }
        }
    }
}
