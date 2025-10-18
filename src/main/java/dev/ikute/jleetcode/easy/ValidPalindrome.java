package dev.ikute.jleetcode.easy;

/**
 * Valid Palindrome problem.
 *
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">Valid Palindrome</a>
 */
public class ValidPalindrome {

    private static final int UNN = -1;

    private static final int NU0 = '0';
    private static final int NU1 = '1';
    private static final int NU2 = '2';
    private static final int NU3 = '3';
    private static final int NU4 = '4';
    private static final int NU5 = '5';
    private static final int NU6 = '6';
    private static final int NU7 = '7';
    private static final int NU8 = '8';
    private static final int NU9 = '9';

    private static final int ALA = 'a';
    private static final int ALB = 'b';
    private static final int ALC = 'c';
    private static final int ALD = 'd';
    private static final int ALE = 'e';
    private static final int ALF = 'f';
    private static final int ALG = 'g';
    private static final int ALH = 'h';
    private static final int ALI = 'i';
    private static final int ALJ = 'j';
    private static final int ALK = 'k';
    private static final int ALL = 'l';
    private static final int ALM = 'm';
    private static final int ALN = 'n';
    private static final int ALO = 'o';
    private static final int ALP = 'p';
    private static final int ALQ = 'q';
    private static final int ALR = 'r';
    private static final int ALS = 's';
    private static final int ALT = 't';
    private static final int ALU = 'u';
    private static final int ALV = 'v';
    private static final int ALW = 'w';
    private static final int ALX = 'x';
    private static final int ALY = 'y';
    private static final int ALZ = 'z';

    private static final int[] LOWER_ALPHANUMERICS = new int[]{
//          0    1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x00-0x0F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x10-0x1F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x20-0x2F
            NU0, NU1, NU2, NU3, NU4, NU5, NU6, NU7, NU8, NU9, UNN, UNN, UNN, UNN, UNN, UNN, // 0x30-0x3F
            UNN, ALA, ALB, ALC, ALD, ALE, ALF, ALG, ALH, ALI, ALJ, ALK, ALL, ALM, ALN, ALO, // 0x40-0x4F
            ALP, ALQ, ALR, ALS, ALT, ALU, ALV, ALW, ALX, ALY, ALZ, UNN, UNN, UNN, UNN, UNN, // 0x50-0x5F
            UNN, ALA, ALB, ALC, ALD, ALE, ALF, ALG, ALH, ALI, ALJ, ALK, ALL, ALM, ALN, ALO, // 0x60-0x6F
            ALP, ALQ, ALR, ALS, ALT, ALU, ALV, ALW, ALX, ALY, ALZ, UNN, UNN, UNN, UNN, UNN, // 0x70-0x7F

            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x80-0x8F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0x90-0x9F
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xA0-0xAF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xB0-0xBF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xC0-0xCF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xD0-0xDF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xE0-0xEF
            UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, UNN, // 0xF0-0xFF
    };

    static boolean isValidPalindrome(String s) {
        int lhs = 0;
        int rhs = s.length() - 1;

        for (; ; ) {
            if (lhs >= rhs) {
                return true;
            }

            int lch = LOWER_ALPHANUMERICS[s.charAt(lhs)];
            int rch = LOWER_ALPHANUMERICS[s.charAt(rhs)];

            if (lch == UNN && rch == UNN) {
                lhs += 1;
                rhs -= 1;
                continue;
            }

            if (lch == UNN) {
                lhs += 1;
                continue;
            }

            if (rch == UNN) {
                rhs -= 1;
                continue;
            }

            if (lch != rch) {
                return false;
            }

            lhs += 1;
            rhs -= 1;
        }
    }

    public boolean isPalindrome(String s) {
        return isValidPalindrome(s);
    }
}
