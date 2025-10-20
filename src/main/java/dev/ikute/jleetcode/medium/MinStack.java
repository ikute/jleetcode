package dev.ikute.jleetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Min Stack problem.
 *
 * @see <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 */
public class MinStack {

    private final Deque<MinValuePair> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            MinValuePair pair = new MinValuePair(val, val);
            stack.addLast(pair);

            return;
        }

        MinValuePair top = stack.peekLast();
        MinValuePair pair = new MinValuePair(val, Math.min(val, top.min));
        stack.addLast(pair);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        stack.pollLast();
    }

    public int top() {
        if (stack.isEmpty()) {
            // wft?
            return Integer.MAX_VALUE;
        }

        MinValuePair top = stack.peekLast();
        return top.value;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        MinValuePair top = stack.peekLast();
        return top.min;
    }

    record MinValuePair(int value, int min) {
    }
}
