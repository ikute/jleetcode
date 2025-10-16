package dev.ikute.jleetcode.medium;

/**
 * Peak Index in a Mountain Array problem.
 *
 * @see <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array">Peak Index in a Mountain Array</a>
 */
public class PeakIndexInMountainArray {

    static int searchMountainIndex(int[] arr) {
        int lhs = 0;
        int rhs = arr.length - 1;

        for (; ; ) {
            if (lhs - rhs > 0) {
                return -1;
            }

            int mid = lhs + (rhs - lhs) / 2;

            int x = arr[mid];
            int lx = mid != 0 ? arr[mid - 1] : -1;
            int rx = mid != arr.length - 1 ? arr[mid + 1] : -1;

            if (lx < x && x > rx) {
                return mid;
            }

            if (lx < x && x < rx) {
                lhs = mid + 1;
            } else {
                rhs = mid - 1;
            }
        }
    }

    public int peakIndexInMountainArray(int[] arr) {
        return searchMountainIndex(arr);
    }
}
