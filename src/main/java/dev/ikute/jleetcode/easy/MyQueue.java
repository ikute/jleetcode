package dev.ikute.jleetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement Queue using Stacks problem.
 *
 * @see <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Implement Queue using Stacks</a>
 */
public class MyQueue {

    private final Deque<Integer> buffer;
    private final Deque<Integer> rstack;

    public MyQueue() {
        this.buffer = new ArrayDeque<>();
        this.rstack = new ArrayDeque<>();
    }

    public void push(int x) {
        buffer.addLast(x);
    }

    public int pop() {
        int value = peek();

        if (value == -1) {
            return -1;
        }

        return rstack.pollLast();
    }

    public int peek() {
        int bufsize = buffer.size();
        int rstacksize = rstack.size();

        if (bufsize == 0 && rstacksize == 0) {
            return -1;
        }

        if (rstacksize != 0) {
            return rstack.peekLast();
        } else {
            for (int idx = 0; idx < bufsize; idx += 1) {
                int value = buffer.pollLast();
                rstack.addLast(value);
            }

            return rstack.peekLast();
        }
    }

    public boolean empty() {
        return rstack.isEmpty() && buffer.isEmpty();
    }
}
