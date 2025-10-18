package dev.ikute.jleetcode.easy;

/**
 * Palindrome Linked List problem.
 *
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list/">Palindrome Linked List</a>
 */
public class PalindromeLinkedList {

    static boolean isLinkedPalindrome(ListNode list) {
        ListNode node = list;
        ListNode rnode = reverse(list);

        for (; ; ) {
            if (node == null || rnode == null) {
                return true;
            }

            if (node.val != rnode.val) {
                return false;
            }

            node = node.next;
            rnode = rnode.next;
        }
    }

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

    public boolean isPalindrome(ListNode head) {
        return isLinkedPalindrome(head);
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
