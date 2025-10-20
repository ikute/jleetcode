package dev.ikute.jleetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Daily Temperatures problem.
 *
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">Daily Temperatures</a>
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int idx = 0; idx < temperatures.length; idx += 1) {
            for (; ; ) {
                if (stack.isEmpty()) {
                    break;
                }

                int isx = stack.peekLast();
                if (temperatures[idx] <= temperatures[isx]) {
                    break;
                }

                stack.pollLast();
                days[isx] = idx - isx;
            }

            stack.addLast(idx);
        }

        return days;
    }
}
