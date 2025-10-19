package dev.ikute.jleetcode.medium;

/**
 * Valid Sudoku problem.
 *
 * @see <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];

        for (int row = 0; row < 9; row += 1) {
            for (int col = 0; col < 9; col += 1) {
                int val = board[row][col];

                if (val != '.') {
                    int num = val - '1';

                    if (rows[row][num] > 0) {
                        return false;
                    } else {
                        rows[row][num] = 1;
                    }

                    if (cols[col][num] > 0) {
                        return false;
                    } else {
                        cols[col][num] = 1;
                    }

                    int box = 3 * (row / 3) + (col / 3);
                    if (boxes[box][num] > 0) {
                        return false;
                    } else {
                        boxes[box][num] = 1;
                    }
                }
            }
        }

        return true;
    }
}
