package dev.ikute.jleetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Merge Intervals problem.
 *
 * @see <a href="https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(it -> it[0]));

        int idx = 1;
        int mlen = 1;
        for (; ; ) {
            if (idx >= intervals.length) {
                break;
            }

            int[] lhs = intervals[mlen - 1];
            int[] rhs = intervals[idx];

            if (rhs[0] <= lhs[1]) {
                lhs[1] = Math.max(lhs[1], rhs[1]);
            } else {
                lhs = intervals[mlen];
                lhs[0] = rhs[0];
                lhs[1] = rhs[1];
                
                mlen += 1;
            }

            idx += 1;
        }

        return Arrays.copyOfRange(intervals, 0, mlen);
    }
}
