package dev.ikute.jleetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Valid Parentheses problem.
 *
 * @see <a href="https://leetcode.com/problems/valid-parentheses">Valid Parentheses</a>
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        return isValidRecursive(new ArrayList<>(s.length()), 0, s);
    }

    private static boolean isValidRecursive(List<Integer> stack, int idx, String s) {
        if (idx == s.length()) {
            return stack.isEmpty();
        }

        if (stack.isEmpty()) {
            char lparen = s.charAt(idx);

            if (!isLeft(lparen)) {
                return false;
            }

            stack.add(idx);
            idx += 1;
            return isValidRecursive(stack, idx, s);
        }

        char lparen = s.charAt(stack.getLast());
        char rparen = s.charAt(idx);

        if (isPair(lparen, rparen)) {
            stack.removeLast();
            idx += 1;
            return isValidRecursive(stack, idx, s);
        }

        if (!isLeft(rparen)) {
            return false;
        }

        stack.add(idx);
        idx += 1;
        return isValidRecursive(stack, idx, s);
    }

    private static boolean isLeft(char paren) {
        return switch (paren) {
            case '(', '{', '[' -> true;
            default -> false;
        };
    }

    private static boolean isPair(char lparen, char rparen) {
        return switch (lparen) {
            case '(' -> rparen == ')';
            case '[' -> rparen == ']';
            case '{' -> rparen == '}';

            default -> false;
        };
    }
}
