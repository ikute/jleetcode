package dev.ikute.jleetcode.medium;

/**
 * Search a 2D Matrix II problem.
 *
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix II</a>
 */
public class Search2DMatrixII {

    static boolean contains2D(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        for (; ; ) {
            if (row >= n || col < 0) {
                return false;
            }

            int elem = matrix[row][col];
            if (elem == target) {
                return true;
            }

            if (elem < target) {
                row += 1;
            } else {
                col -= 1;
            }
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return contains2D(matrix, target);
    }
}
