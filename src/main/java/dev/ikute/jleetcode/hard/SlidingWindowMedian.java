package dev.ikute.jleetcode.hard;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Sliding Window Median problem.
 *
 * @see <a href="https://leetcode.com/problems/sliding-window-median/">Sliding Window Median</a>
 */
public class SlidingWindowMedian {

    static double[] slideMedians(int[] nums, int n, int k) {
        double[] medians = new double[n - k + 1];

        Comparator<Integer> cmp = (idx, ijx) -> nums[idx] != nums[ijx]
                ? Integer.compare(nums[idx], nums[ijx])
                : Integer.compare(idx, ijx);

        TreeSet<Integer> lhs = new TreeSet<>(cmp);
        TreeSet<Integer> rhs = new TreeSet<>(cmp);

        for (int idx = 0; idx < n; idx += 1) {
            rhs.add(idx);
            lhs.add(rhs.pollFirst());

            if (lhs.size() > rhs.size()) {
                rhs.add(lhs.pollLast());
            }

            if (lhs.size() + rhs.size() == k) {
                medians[idx - k + 1] = (k & 1) == 0
                        ? ((double) nums[lhs.last()] + (double) nums[rhs.first()]) / 2.0
                        : (double) nums[rhs.first()];

                lhs.remove(idx - k + 1);
                rhs.remove(idx - k + 1);
            }
        }
        return medians;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        return slideMedians(nums, nums.length, k);
    }
}
