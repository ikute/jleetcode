package dev.ikute.jleetcode.easy;

/**
 * Merge Sorted Array problem.
 *
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 */
public class MergeSortedArray {

    static void mergeSorted(int[] p1, int l1, int[] p2, int l2, int[] out) {
        int i1 = l1 - 1;
        int i2 = l2 - 1;
        int i = out.length - 1;

        for (; ; ) {
            if (i < 0) {
                return;
            }

            if (i1 >= 0 && i2 >= 0) {
                if (p1[i1] > p2[i2]) {
                    out[i] = p1[i1];
                    i1 -= 1;
                } else {
                    out[i] = p2[i2];
                    i2 -= 1;
                }

                i -= 1;
                continue;
            }

            if (i1 >= 0) {
                out[i] = p1[i1];

                i1 -= 1;
                i -= 1;
                continue;
            }

            if (i2 >= 0) {
                out[i] = p2[i2];

                i2 -= 1;
                i -= 1;
                continue;
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeSorted(nums1, m, nums2, n, nums1);
    }
}
