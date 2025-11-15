package dev.ikute.jleetcode.medium;

/**
 * Average Waiting Time problem.
 *
 * @see <a href="https://leetcode.com/problems/average-waiting-time/">Average Waiting Time</a>
 */
public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        long waiting = 0;
        long time = 0;

        for (int[] customer : customers) {
            time = Math.max(time, customer[0]) + customer[1];
            waiting += Math.max(0, time - customer[0]);
        }

        return ((double) waiting) / ((double) customers.length);
    }
}
