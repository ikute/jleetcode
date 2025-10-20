package dev.ikute.jleetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement Stack using Queues problem.
 *
 * @see <a href="https://leetcode.com/problems/implement-stack-using-queues/">Implement Stack using Queues</a>
 */
public class MyStack {

    private final Deque<Integer> rqueue;

    public MyStack() {
        this.rqueue = new ArrayDeque<>();
    }

    public void push(int x) {
        int rqsize = rqueue.size();

        rqueue.addLast(x);

        for (int idx = 0; idx < rqsize; idx += 1) {
            int value = rqueue.pollFirst();
            rqueue.addLast(value);
        }
    }

    public int pop() {
        Integer value = rqueue.pollFirst();
        return value != null ? value : -1;
    }

    public int top() {
        Integer value = rqueue.peekFirst();
        return value != null ? value : -1;
    }

    public boolean empty() {
        return rqueue.isEmpty();
    }
}
