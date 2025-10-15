package dev.ikute.jleetcode.medium;

/**
 * String to Integer problem.
 *
 * @see <a href="https://leetcode.com/problems/string-to-integer-atoi/">String to Integer (atoi)</a>
 */
public class StringToInteger {

    private static final int NAN = -1;
    private static final int NUM = 0;
    private static final int SPC = 1;
    private static final int PLS = 2;
    private static final int MNS = 3;

    private static final int[] DECODE_KEYS = new int[]{
//          0    1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0x00-0x0F
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0x10-0x1F
            SPC, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, PLS, NAN, MNS, NAN, NAN, // 0x20-0x2F
            NUM, NUM, NUM, NUM, NUM, NUM, NUM, NUM, NUM, NUM, NAN, NAN, NAN, NAN, NAN, NAN, // 0x30-0x3F
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0x40-0x4F
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0x50-0x5F
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0x60-0x6F
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0x70-0x7F

            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0x80-0x8F
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0x90-0x9F
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0xA0-0xAF
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0xB0-0xBF
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0xC0-0xCF
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0xD0-0xDF
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0xE0-0xEF
            NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, NAN, // 0xF0-0xFF
    };

    public static int atoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int val = 0;
        boolean isNonNegative = true;
        int idx = 0;

        int fch = s.charAt(idx);
        int key = DECODE_KEYS[fch];

        for (; ; ) {
            switch (key) {
                case NUM -> {
                    val = isNonNegative ? s.charAt(idx) - '0' : -(s.charAt(idx) - '0');

                    for (; ; ) {
                        idx += 1;

                        if (idx >= s.length()) {
                            return val;
                        }

                        int ch = s.charAt(idx);
                        if (DECODE_KEYS[ch] != NUM) {
                            return val;
                        }

                        int n = (ch - '0');
                        if (isNonNegative) {
                            if (Integer.MAX_VALUE / 10 < val) {
                                return Integer.MAX_VALUE;
                            }
                            val *= 10;

                            if (Integer.MAX_VALUE - n <= val) {
                                return Integer.MAX_VALUE;
                            }
                            val += n;
                        } else {
                            if (Integer.MIN_VALUE / 10 > val) {
                                return Integer.MIN_VALUE;
                            }
                            val *= 10;

                            if (Integer.MIN_VALUE + n >= val) {
                                return Integer.MIN_VALUE;
                            }
                            val -= n;
                        }
                    }
                }

                case SPC -> {
                    for (; ; ) {
                        idx += 1;

                        if (idx >= s.length()) {
                            return val;
                        }

                        key = DECODE_KEYS[s.charAt(idx)];

                        if (key != SPC) {
                            break;
                        }
                    }
                }

                case PLS -> {
                    idx += 1;

                    if (idx >= s.length()) {
                        return val;
                    }

                    key = DECODE_KEYS[s.charAt(idx)];
                    if (key != NUM) {
                        return val;
                    }
                }

                case MNS -> {
                    idx += 1;

                    if (idx >= s.length()) {
                        return val;
                    }

                    key = DECODE_KEYS[s.charAt(idx)];
                    if (key != NUM) {
                        return val;
                    }

                    isNonNegative = false;
                }

                default -> {
                    return val;
                }
            }
        }
    }

    public int myAtoi(String s) {
        return atoi(s);
    }
}
