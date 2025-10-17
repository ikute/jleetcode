package dev.ikute.jleetcode.medium;

/**
 * Sort Colors problem.
 *
 * @see <a href="https://leetcode.com/problems/sort-colors/">Sort Colors</a>
 */
public class SortColors {

    static void sort(int[] nums) {
        int reds = 0;
        int whites = 0;
        int blues = 0;

        for (int idx = 0; idx < nums.length; idx += 1) {
            switch (nums[idx]) {
                case 0 -> reds += 1;
                case 1 -> whites += 1;
                case 2 -> blues += 1;
                default -> {
                }
            }
        }

        for (int idx = 0; idx < reds; idx += 1) {
            nums[idx] = 0;
        }

        for (int idx = reds; idx < reds + whites; idx += 1) {
            nums[idx] = 1;
        }

        for (int idx = reds + whites; idx < reds + whites + blues; idx += 1) {
            nums[idx] = 2;
        }
    }

    public void sortColors(int[] nums) {
        sort(nums);
    }
}
