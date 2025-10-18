package dev.ikute.jleetcode.easy;

/**
 * Length of Last Word problem.
 *
 * @see <a href="https://leetcode.com/problems/length-of-last-word/">Length of Last Word</a>
 */
public class LengthOfLastWord {

    private static final int UNN = -1;
    private static final int SPC = 1;
    private static final int APH = 2;

    private static final int[] ASCII_KEYS = new int[]{
//          0    1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x00-0x0F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x10-0x1F
            SPC, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x20-0x2F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x30-0x3F
            UNN, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, // 0x40-0x4F
            APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, UNN, UNN, UNN, UNN, UNN, // 0x50-0x5F
            UNN, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, // 0x60-0x6F
            APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, APH, UNN, UNN, UNN, UNN, UNN, // 0x70-0x7F

            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x80-0x8F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x90-0x9F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xA0-0xAF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xB0-0xBF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xC0-0xCF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xD0-0xDF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xE0-0xEF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xF0-0xFF
    };

    static int lastWordLen(String s) {
        int len = 0;
        int key, idx = s.length() - 1;

        for (; ; ) {
            if (idx < 0) {
                return len;
            }

            key = ASCII_KEYS[s.charAt(idx)];
            if (key != SPC) {
                break;
            }

            idx -= 1;
        }

        for (; ; ) {
            if (idx < 0) {
                return len;
            }

            key = ASCII_KEYS[s.charAt(idx)];
            if (key != APH) {
                return len;
            }

            len += 1;
            idx -= 1;
        }
    }

    public int lengthOfLastWord(String s) {
        return lastWordLen(s);
    }
}
