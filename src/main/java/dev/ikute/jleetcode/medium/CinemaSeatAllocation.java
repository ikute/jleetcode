package dev.ikute.jleetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Cinema Seat Allocation problem.
 *
 * @see <a href="https://leetcode.com/problems/cinema-seat-allocation/">Cinema Seat Allocation</a>
 */
public class CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rmasks = new HashMap<>();

        for (int[] reserve : reservedSeats) {
            int row = reserve[0];
            int seat = reserve[1];

            if (!rmasks.containsKey(row)) {
                rmasks.put(row, 0);
            }

            rmasks.put(row, rmasks.get(row) | 1 << seat);
        }

        int seats = 0;
        seats += (n - rmasks.size()) * 2;

        for (int mask : rmasks.values()) {
            boolean LS = (mask & ((1 << 2) | (1 << 3) | (1 << 4) | (1 << 5))) == 0;
            boolean RS = (mask & ((1 << 6) | (1 << 7) | (1 << 8) | (1 << 9))) == 0;
            boolean MS = (mask & ((1 << 4) | (1 << 5) | (1 << 6) | (1 << 7))) == 0;

            if (LS && RS) {
                seats += 2;
            } else if (LS || RS || MS) {
                seats += 1;
            }
        }

        return seats;
    }
}
