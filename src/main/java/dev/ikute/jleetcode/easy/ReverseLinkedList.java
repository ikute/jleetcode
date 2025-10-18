package dev.ikute.jleetcode.easy;

/**
 * Reverse Linked List problem.
 *
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 */
public class ReverseLinkedList {

    static ListNode reverse(ListNode list) {
        ListNode node = list;
        ListNode rnode = null;
        for (; ; ) {
            if (node == null) {
                return rnode;
            }

            rnode = new ListNode(node.val, rnode);
            node = node.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
