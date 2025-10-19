package dev.ikute.jleetcode.easy;

/**
 * Matrix Diagonal Sum problem.
 *
 * @see <a href="https://leetcode.com/problems/matrix-diagonal-sum/">Matrix Diagonal Sum</a>
 */
public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for (int d = 0; d < mat.length; d += 1) {
            sum += mat[d][d];

            if (mat.length - 1 - d != d) {
                sum += mat[mat.length - 1 - d][d];
            }
        }

        return sum;
    }
}
