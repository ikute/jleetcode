package dev.ikute.jleetcode.medium;

/**
 * Find First and Last Position of Element in Sorted Array problem.
 *
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">
 * Find First and Last Position of Element in Sorted Array
 * </a>
 */
public class FindFirstAndLastPositionInSortedArray {

    static int[] searchNonDescending(int[] nums, int target) {
        int lhs = 0;
        int rhs = nums.length - 1;

        for (; ; ) {
            if (lhs - rhs > 0) {
                return new int[]{-1, -1};
            }

            int mid = lhs + (rhs - lhs) / 2;
            int n = nums[mid];
            if (n == target) {
                int lr = mid;
                for (; ; ) {
                    if (lr <= 0) {
                        break;
                    }

                    if (nums[lr - 1] != target) {
                        break;
                    }

                    lr -= 1;
                }

                int rr = mid;
                for (; ; ) {
                    if (rr >= nums.length - 1) {
                        break;
                    }

                    if (nums[rr + 1] != target) {
                        break;
                    }

                    rr += 1;
                }

                return new int[]{lr, rr};
            }

            if (n < target) {
                lhs = mid + 1;
                for (; ; ) {
                    if (lhs > rhs) {
                        break;
                    }

                    if (nums[lhs] != n) {
                        break;
                    }

                    lhs += 1;
                }
            } else {
                rhs = mid - 1;
                for (; ; ) {
                    if (lhs > rhs) {
                        break;
                    }

                    if (nums[rhs] != n) {
                        break;
                    }

                    rhs -= 1;
                }
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        return searchNonDescending(nums, target);
    }
}
