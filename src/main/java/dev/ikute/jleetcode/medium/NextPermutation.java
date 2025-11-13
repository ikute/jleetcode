package dev.ikute.jleetcode.medium;

/**
 * Next Permutation problem.
 *
 * @see <a href="https://leetcode.com/problems/next-permutation/">Next Permutation</a>
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int bp = -1;

        for (int idx = nums.length - 2; idx >= 0; idx -= 1) {
            if (nums[idx] < nums[idx + 1]) {
                bp = idx;
                break;
            }
        }

        if (bp == -1) {
            reverse(nums);
            return;
        }

        for (int idx = nums.length - 1; ; idx -= 1) {
            if (nums[idx] > nums[bp]) {
                swap(nums, idx, bp);
                reverse(nums, bp + 1, nums.length - 1);

                return;
            }
        }
    }

    static void reverse(int[] p) {
        reverse(p, 0, p.length - 1);
    }

    static void reverse(int[] p, int start, int end) {
        int lhs = start;
        int rhs = end;

        for (; ; ) {
            if (lhs >= rhs) {
                break;
            }

            swap(p, lhs, rhs);
            lhs += 1;
            rhs -= 1;
        }
    }

    static void swap(int[] p, int lhs, int rhs) {
        p[lhs] ^= p[rhs];
        p[rhs] ^= p[lhs];
        p[lhs] ^= p[rhs];
    }
}
