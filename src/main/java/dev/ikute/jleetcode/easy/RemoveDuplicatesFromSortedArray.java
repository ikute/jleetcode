package dev.ikute.jleetcode.easy;

/**
 * Remove Duplicates from Sorted Array problem.
 *
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">Remove Duplicates from Sorted Array</a>
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }

        return removeDuplicatesRecursive(nums, 0, nums, 0);
    }

    private int removeDuplicatesRecursive(int[] uniques, int ulen, int[] nums, int idx) {
        if (idx == nums.length) {
            return ulen;
        }

        if (ulen == 0) {
            uniques[0] = nums[idx];
            return removeDuplicatesRecursive(uniques, ulen + 1, nums, idx + 1);
        }

        int next = nums[idx];
        int lastUnique = uniques[ulen - 1];

        if (next == lastUnique) {
            return removeDuplicatesRecursive(uniques, ulen, nums, idx + 1);
        }

        uniques[ulen] = next;
        return removeDuplicatesRecursive(uniques, ulen + 1, nums, idx + 1);
    }
}
