package dev.ikute.jleetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 01 Matrix problem.
 *
 * @see <a href="https://leetcode.com/problems/01-matrix/">01 Matrix</a>
 */
public class Matrix01 {

    public int[][] updateMatrix(int[][] mtx) {
        int n = mtx.length;
        int m = mtx[0].length;

        int[][] dsts = new int[n][m];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (mtx[i][j] == 0) {
                    dsts[i][j] = 0;
                    queue.addLast(new int[]{i, j});
                } else {
                    dsts[i][j] = -1;
                }
            }
        }

        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, 1, -1};

        for (; ; ) {
            if (queue.isEmpty()) {
                break;
            }

            int[] ij = queue.pollFirst();
            int i = ij[0];
            int j = ij[1];

            int dst = dsts[i][j];
            for (int k = 0; k < di.length; k += 1) {
                int ki = i + di[k];
                int kj = j + dj[k];

                if (ki >= 0 && kj >= 0 && ki < n && kj < m && dsts[ki][kj] == -1) {
                    dsts[ki][kj] = dst + 1;
                    queue.addLast(new int[]{ki, kj});
                }
            }
        }

        return dsts;
    }
}
