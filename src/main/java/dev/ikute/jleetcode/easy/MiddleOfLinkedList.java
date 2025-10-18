package dev.ikute.jleetcode.easy;

/**
 * Middle of the Linked List problem.
 *
 * @see <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Middle of the Linked List</a>
 */
public class MiddleOfLinkedList {

    static ListNode nodeAtMiddle(ListNode list) {
        int len = len(list);
        int mid = len / 2;

        return nodeAt(list, mid);
    }

    static ListNode nodeAt(ListNode list, int index) {
        ListNode node = list;
        for (int idx = 0; idx < index; idx += 1) {
            if (node == null) {
                return node;
            }

            node = node.next;
        }

        return node;
    }

    static int len(ListNode list) {
        int len = 0;

        ListNode node = list;
        for (; ; ) {
            if (node == null) {
                break;
            }

            node = node.next;
            len += 1;
        }

        return len;
    }

    public ListNode middleNode(ListNode head) {
        return nodeAtMiddle(head);
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
