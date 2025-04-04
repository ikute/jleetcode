package dev.ikute.jleetcode.easy;

/**
 * Merge Two Sorted Lists problem.
 *
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists">Merge Two Sorted Lists</a>
 */
public class MergeTwoSortedLists {

    static ListNode merge2(ListNode l1, ListNode l2) {
        ListNode overlist = new ListNode();
        ListNode node = overlist;

        for (; ; ) {
            if (isEmpty(l1) && isEmpty(l2)) {
                return overlist.next;
            }

            if (isEmpty(l1)) {
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;

                continue;
            }

            if (isEmpty(l2)) {
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;

                continue;
            }

            if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
            }
        }
    }

    static boolean isEmpty(ListNode list) {
        return list == null;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge2(list1, list2);
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
