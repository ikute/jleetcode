package dev.ikute.jleetcode.easy;

/**
 * Palindrome Number problem.
 *
 * @see <a href="https://leetcode.com/problems/palindrome-number">Palindrome Number</a>
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return isPositivePalindrome(x);
    }

    public boolean isPositivePalindrome(int x) {
        if (x < 10) {
            return true;
        }

        int ord = 10;
        for (; ; ) {
            if (x / ord < 10) {
                break;
            }

            ord *= 10;
        }

        return isPositivePalindrome(x, ord);
    }

    public boolean isPositivePalindrome(int x, int ord) {
        if (ord < 10) {
            return true;
        }

        int q = x / ord;
        int r = x % 10;

        if (q - r != 0) {
            return false;
        }

        return isPositivePalindrome((x - (q * ord + r)) / 10, ord / 100);
    }
}
