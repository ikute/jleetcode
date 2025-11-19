package dev.ikute.jleetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Sliding Window Maximum problem.
 *
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a>
 */
public class SlidingWindowMaximum {

    static int[] slideMaxes(int[] nums, int n, int k) {
        int[] maxes = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>(k);

        int idx = 0;
        int imx = 0;
        for (; ; ) {
            if (idx >= n) {
                return maxes;
            }

            while (!dq.isEmpty() && dq.peekFirst() < idx - k + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[idx]) {
                dq.pollLast();
            }

            dq.offerLast(idx);

            if (idx >= k - 1) {
                maxes[imx] = nums[dq.peekFirst()];
                imx += 1;
            }

            idx += 1;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        return slideMaxes(nums, nums.length, k);
    }
}
