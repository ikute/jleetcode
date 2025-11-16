package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Interval List Intersections problem.
 *
 * @see <a href="https://leetcode.com/problems/interval-list-intersections/">Interval List Intersections</a>
 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersection = new ArrayList<>();

        int ifx = 0, isx = 0;
        for (; ; ) {
            if (ifx >= firstList.length || isx >= secondList.length) {
                return intersection.toArray(new int[intersection.size()][]);
            }

            int[] fint = firstList[ifx];
            int[] sint = secondList[isx];

            int lhs = Math.max(fint[0], sint[0]);
            int rhs = Math.min(fint[1], sint[1]);
            if (lhs <= rhs) {
                intersection.add(new int[]{lhs, rhs});
            }

            if (fint[1] <= sint[1]) {
                ifx += 1;
            } else {
                isx += 1;
            }
        }
    }
}
