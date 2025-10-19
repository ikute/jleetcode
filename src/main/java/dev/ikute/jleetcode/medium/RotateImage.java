package dev.ikute.jleetcode.medium;

/**
 * Rotate Image problem.
 *
 * @see <a href="https://leetcode.com/problems/rotate-image/">Rotate Image</a>
 */
public class RotateImage {

    static void rotate2(int[][] matrix) {
        for (int i = 0; i < matrix.length; i += 1) {
            for (int j = i + 1; j < matrix.length; j += 1) {
                swap2(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < matrix.length; i += 1) {
            reverse(matrix[i]);
        }
    }

    static void reverse(int[] s) {
        int lhs = 0;
        int rhs = s.length - 1;

        for (; ; ) {
            if (lhs >= rhs) {
                break;
            }

            swap(s, lhs, rhs);
            lhs += 1;
            rhs -= 1;
        }
    }

    static void swap2(int[][] m, int li, int lj, int ri, int rj) {
        m[li][lj] ^= m[ri][rj];
        m[ri][rj] ^= m[li][lj];
        m[li][lj] ^= m[ri][rj];
    }

    static void swap(int[] p, int lhs, int rhs) {
        p[lhs] ^= p[rhs];
        p[rhs] ^= p[lhs];
        p[lhs] ^= p[rhs];
    }

    public void rotate(int[][] matrix) {
        rotate2(matrix);
    }
}
