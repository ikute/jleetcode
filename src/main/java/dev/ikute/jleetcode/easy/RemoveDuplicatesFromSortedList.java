package dev.ikute.jleetcode.easy;

/**
 * Remove Duplicates from Sorted List problem.
 *
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">
 * Remove Duplicates from Sorted List
 * </a>
 */
public class RemoveDuplicatesFromSortedList {

    static ListNode removeDuplicates(ListNode list) {
        ListNode node = list, tail = list;
        for (; ; ) {
            if (node == null) {
                return list;
            }

            if (tail == null) {
                node = node.next;
                continue;
            }

            if (node.val == tail.val) {
                if (tail.next == null) {
                    node.next = null;
                }

                tail = tail.next;
            } else {
                node.next = tail;
                node = node.next;
            }
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        return removeDuplicates(head);
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
