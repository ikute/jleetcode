package dev.ikute.jleetcode.medium;

/**
 * Zigzag Conversion problem.
 *
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/">Zigzag Conversion</a>
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        char[] chars = s.toCharArray();
        char[] converted = new char[chars.length];

        int convertedIdx = 0;
        for (int row = 0; row < numRows; row += 1) {
            int dstep, ustep;
            boolean sameSteps = row % (numRows - 1) == 0;

            if (sameSteps) {
                int step = 2 * (numRows - 1);
                dstep = step;
                ustep = step;
            } else {
                dstep = 2 * ((numRows - 1) - row);
                ustep = 2 * ((numRows - 1) - ((numRows - 1) - row));
            }

            int charsIdx = row;
            for (; ; ) {
                if (charsIdx >= chars.length) {
                    break;
                }

                converted[convertedIdx] = chars[charsIdx];
                convertedIdx += 1;
                charsIdx += dstep;

                if (charsIdx >= chars.length) {
                    break;
                }

                converted[convertedIdx] = chars[charsIdx];
                convertedIdx += 1;
                charsIdx += ustep;
            }
        }

        return String.valueOf(converted);
    }
}
