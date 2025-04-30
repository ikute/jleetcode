package dev.ikute.jleetcode.easy;

/**
 * Valid Perfect Square problem.
 *
 * @see <a href="https://leetcode.com/problems/valid-perfect-square">Valid Perfect Square</a>
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int square) {
        if (square == 1) {
            return true;
        }

        if (square == Integer.MAX_VALUE) {
            return false;
        }

        return isPerfectSquare(2, square / 2, square);
    }

    private static boolean isPerfectSquare(int lhs, int rhs, int square) {
        if (lhs == rhs) {
            return square(lhs) == square;
        }

        int mid = lhs + (rhs - lhs) / 2;

        if (square(mid) < square) {
            return isPerfectSquare(mid + 1, rhs, square);
        } else {
            return isPerfectSquare(lhs, mid, square);
        }
    }

    private static int square(int root) {
        if (Integer.MAX_VALUE / root < root) {
            return Integer.MAX_VALUE;
        }

        return root * root;
    }
}
