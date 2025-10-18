package dev.ikute.jleetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge k Sorted Lists problem.
 *
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 */
public class MergeKSortedLists {

    static ListNode mergeN(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        List<ListNode> merged = new ArrayList<>(Arrays.asList(lists));
        for (; ; ) {
            if (merged.size() <= 1) {
                return merged.getFirst();
            }

            List<ListNode> next = new ArrayList<>(merged.size() / 2 + 1);
            for (int idx = 0; idx < merged.size(); idx += 2) {
                ListNode l1 = merged.get(idx);
                ListNode l2 = idx + 1 < merged.size() ? merged.get(idx + 1) : null;

                ListNode ml = merge2(l1, l2);
                next.add(ml);
            }

            merged = next;
        }
    }

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

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeN(lists);
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
