package dev.ikute.jleetcode.easy;

/**
 * Move Zeroes problem.
 *
 * @see <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 */
public class MoveZeroes {

    static void move(int[] nums, int x) {
        int idx = 0;
        int izx = 0;

        for (; ; ) {
            if (idx >= nums.length) {
                break;
            }

            if (nums[idx] == x) {
                break;
            }

            idx += 1;
            izx += 1;
        }

        for (; ; ) {
            if (idx >= nums.length) {
                break;
            }

            if (nums[idx] != x) {
                nums[izx] = nums[idx];
                nums[idx] = x;

                izx += 1;
                idx += 1;
                continue;
            }

            idx += 1;
        }
    }

    public void moveZeroes(int[] nums) {
        move(nums, 0);
    }
}
