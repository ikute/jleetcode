package dev.ikute.jleetcode.medium;

/**
 * Integer to Roman problem.
 *
 * @see <a href="https://leetcode.com/problems/integer-to-roman/">Integer to Roman</a>
 */
public class IntegerToRoman {

    static String toRoman(int num) {
        int[] numbuf = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rombuf = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romans = new StringBuilder();

        int order = 0;
        for (; ; ) {
            if (num <= 0) {
                break;
            }

            if (num >= numbuf[order]) {
                romans.append(rombuf[order]);
                num -= numbuf[order];
            } else {
                order += 1;
            }
        }

        return romans.toString();
    }

    public String intToRoman(int num) {
        return toRoman(num);
    }
}
