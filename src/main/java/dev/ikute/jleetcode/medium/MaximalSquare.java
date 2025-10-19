package dev.ikute.jleetcode.medium;

/**
 * Maximal Square problem.
 *
 * @see <a href="https://leetcode.com/problems/maximal-square/">Maximal Square</a>
 */
public class MaximalSquare {

    static int maxSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] areas = new int[rows][cols];
        int ssize = 0;

        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < cols; j += 1) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        areas[i][j] = 1;
                    } else {
                        areas[i][j] = 1 + Math.min(
                                Math.min(areas[i][j - 1], areas[i - 1][j]),
                                areas[i - 1][j - 1]
                        );
                    }

                    ssize = Math.max(ssize, areas[i][j]);
                }
            }
        }

        return ssize * ssize;
    }

    public int maximalSquare(char[][] matrix) {
        return maxSquare(matrix);
    }
}
