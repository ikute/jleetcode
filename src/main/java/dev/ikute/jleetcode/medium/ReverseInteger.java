package dev.ikute.jleetcode.medium;

/**
 * Reverse Integer problem.
 *
 * @see <a href="https://leetcode.com/problems/reverse-integer/">Reverse Integer</a>
 */
public class ReverseInteger {

    public int reverse(int x) {
        int rax = 0;
        int ax;
        boolean isNonNegative = x >= 0;
        if (isNonNegative) {
            ax = x;
        } else {
            ax = -x;
        }

        int digitsNumber = digitsNumber(ax);

        int rscale = 1;
        int scale = powUnsigned(10, digitsNumber - 1);
        if (scale == -1) {
            return 0;
        }

        for (; ; ) {
            if (scale == 0) {
                return isNonNegative ? rax : -rax;
            }

            int n = ax / scale;
            int rn = mulUnsigned(n, rscale);
            if (rn == -1) {
                return 0;
            }

            ax -= n * scale;
            rax = addUnsigned(rax, rn);
            if (rax == -1) {
                return 0;
            }

            scale /= 10;
            rscale *= 10;
        }
    }

    static int digitsNumber(int x) {
        int mutX = x;
        int digitsNumber = 0;

        for (; ; ) {
            if (mutX == 0) {
                break;
            }

            mutX /= 10;
            digitsNumber += 1;
        }

        return digitsNumber;
    }

    static int powUnsigned(int base, int exp) {
        if (base == 0) {
            return 0;
        }

        int pow = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                pow *= base;
            }

            base *= base;
            exp >>= 1;

            if (pow == 0) {
                return -1;
            }
        }

        return pow;
    }

    static int mulUnsigned(int a, int b) {
        int mul = 0;

        while (b != 0) {
            if ((b & 1) != 0) {
                mul += a;
            }

            a <<= 1;
            b >>>= 1;

            if (mul < 0) {
                return -1;
            }
        }

        return mul;
    }

    static int addUnsigned(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;

            if (a < 0) {
                return -1;
            }
        }
        return a;
    }
}
