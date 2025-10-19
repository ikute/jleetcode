package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix problem.
 *
 * @see <a href="https://leetcode.com/problems/spiral-matrix/">Spiral Matrix</a>
 */
public class SpiralMatrix {

    static List<Integer> spiralOrderElements(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> elements = new ArrayList<>(rows * cols);

        int top = 0;
        int bot = rows - 1;
        int left = 0;
        int right = cols - 1;
        for (; ; ) {
            if (top > bot || left > right) {
                break;
            }

            for (int idx = left; idx <= right; idx += 1) {
                elements.add(matrix[top][idx]);
            }

            top += 1;

            for (int idx = top; idx <= bot; idx += 1) {
                elements.add(matrix[idx][right]);
            }

            right -= 1;

            if (top <= bot) {
                for (int idx = right; idx >= left; idx -= 1) {
                    elements.add(matrix[bot][idx]);
                }
                bot -= 1;
            }

            if (left <= right) {
                for (int idx = bot; idx >= top; idx -= 1) {
                    elements.add(matrix[idx][left]);
                }
                left += 1;
            }
        }

        return elements;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrderElements(matrix);
    }
}
