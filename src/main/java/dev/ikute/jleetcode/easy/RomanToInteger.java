package dev.ikute.jleetcode.easy;

import java.nio.CharBuffer;

/**
 * Roman To Integer problem.
 *
 * @see <a href="https://leetcode.com/problems/roman-to-integer">Roman To Integer</a>
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        return romanToInt(0, CharBuffer.wrap(s));
    }

    public int romanToInt(int acc, CharBuffer romans) {
        int romansSize = romans.length();
        if (romansSize == 0) {
            return acc;
        }

        if (romansSize < 2) {
            int num = toInteger(romans.charAt(0));
            acc += num;

            return acc;
        }

        int lnum = toInteger(romans.charAt(0));
        int rnum = toInteger(romans.charAt(1));

        if (lnum < rnum) {
            acc += rnum - lnum;
            return romanToInt(acc, romans.subSequence(2, romansSize));
        }

        acc += lnum;
        return romanToInt(acc, romans.subSequence(1, romansSize));
    }

    private int toInteger(char roman) {
        return switch (roman) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;

            default -> 0;
        };
    }
}
