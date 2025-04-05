package dev.ikute.jleetcode.easy;

/**
 * Remove Element problem.
 *
 * @see <a href="https://leetcode.com/problems/remove-element">Remove Element</a>
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        return removeElementRecursive(nums, 0, nums, 0, val);
    }

    private static int removeElementRecursive(int[] removed, int rlen, int[] nums, int idx, int val) {
        if (idx == nums.length) {
            return rlen;
        }

        int num = nums[idx];

        if (num == val) {
            return removeElementRecursive(removed, rlen, nums, idx + 1, val);
        }

        removed[rlen] = num;
        return removeElementRecursive(removed, rlen + 1, nums, idx + 1, val);
    }
}
