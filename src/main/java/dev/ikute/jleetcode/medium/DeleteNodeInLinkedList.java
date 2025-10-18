package dev.ikute.jleetcode.medium;

/**
 * Delete Node in a Linked List problem.
 *
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Delete Node in a Linked List</a>
 */
public class DeleteNodeInLinkedList {

    static void remove(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        if (node.next.next == null) {
            node.val = node.next.val;
            node.next = null;

            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode(ListNode node) {
        remove(node);
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
