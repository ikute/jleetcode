package dev.ikute.jleetcode.medium;

/**
 * Search a 2D Matrix problem.
 *
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
 */
public class Search2DMatrix {

    static boolean contains2D(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = -1;
        {
            int lhs = 0;
            int rhs = n - 1;

            for (; ; ) {
                if (lhs - rhs > 0) {
                    row = Math.max(rhs, 0);
                    break;
                }

                int mid = lhs + (rhs - lhs) / 2;
                if (matrix[mid][0] == target) {
                    row = mid;
                    break;
                }

                if (matrix[mid][0] < target) {
                    lhs = mid + 1;
                } else {
                    rhs = mid - 1;
                }
            }
        }

        int col = -1;
        {
            int lhs = 0;
            int rhs = m - 1;

            for (; ; ) {
                if (lhs - rhs > 0) {
                    break;
                }

                int mid = lhs + (rhs - lhs) / 2;
                if (matrix[row][mid] == target) {
                    col = mid;
                    break;
                }

                if (matrix[row][mid] < target) {
                    lhs = mid + 1;
                } else {
                    rhs = mid - 1;
                }
            }
        }

        return col >= 0;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return contains2D(matrix, target);
    }
}
