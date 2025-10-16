package dev.ikute.jleetcode.medium;

/**
 * Search in Rotated Sorted Array problem.
 *
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated Sorted Array</a>
 */
public class SearchInRotatedSortedArray {

    static int binarySearch(int[] nums, int target) {
        int lhs = 0;
        int rhs = nums.length - 1;

        for (; ; ) {
            if (lhs - rhs > 0) {
                return -1;
            }

            int mid = lhs + (rhs - lhs) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                rhs = mid - 1;
            } else {
                lhs = mid + 1;
            }
        }
    }

    static int binarySearchOffset(int[] nums, int offset, int target) {
        int lhs, rhs;
        if (nums[0] <= target && target <= nums[offset - 1]) {
            lhs = 0;
            rhs = offset - 1;
        } else {
            lhs = offset;
            rhs = nums.length - 1;
        }

        for (; ; ) {
            if (lhs - rhs > 0) {
                return -1;
            }

            int mid = lhs + (rhs - lhs) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                rhs = mid - 1;
            } else {
                lhs = mid + 1;
            }
        }
    }

    static int searchRotationOffset(int[] nums) {
        if (nums.length < 2 || nums[0] < nums[nums.length - 1]) {
            return 0;
        }

        int lhs = 0;
        int rhs = nums.length - 1;

        for (; ; ) {
            if (lhs - rhs > 0) {
                return -1;
            }

            int mid = lhs + (rhs - lhs) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (nums[mid + 1] > nums[nums.length - 1]) {
                lhs = mid + 1;
            } else {
                rhs = mid - 1;
            }
        }
    }

    public int search(int[] nums, int target) {
        int offset = searchRotationOffset(nums);
        return offset == 0 ? binarySearch(nums, target) : binarySearchOffset(nums, offset, target);
    }
}
