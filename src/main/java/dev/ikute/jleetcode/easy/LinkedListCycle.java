package dev.ikute.jleetcode.easy;

/**
 * Linked List Cycle problem.
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">Linked List Cycle</a>
 */
public class LinkedListCycle {

    static boolean isCycled(ListNode list) {
        if (list == null) {
            return false;
        }

        ListNode snode = list, fnode = list;
        for (; ; ) {
            if (fnode == null || fnode.next == null) {
                return false;
            }

            snode = snode.next;
            fnode = fnode.next.next;

            if (snode == fnode) {
                return true;
            }
        }
    }

    public boolean hasCycle(ListNode head) {
        return isCycled(head);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
