package dev.ikute.jleetcode.medium;

/**
 * Add Two Numbers problem.
 *
 * @see <a href="https://leetcode.com/problems/add-two-numbers">Add Two Numbers</a>
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode lhs, ListNode rhs) {
        return addTwoNumbersRecursive(lhs, rhs);
    }

    private static ListNode addTwoNumbersRecursive(ListNode lhs, ListNode rhs) {
        ListNode sum = new ListNode(0);

        int num = lhs.val + rhs.val;
        sum.val = num % 10;
        int overflow = num / 10;

        if (isEmpty(lhs.next) && isEmpty(rhs.next) && overflow == 0) {
            return sum;
        }

        return addTwoNumbersRecursive(sum, sum, lhs.next, rhs.next, overflow);
    }

    private static ListNode addTwoNumbersRecursive(ListNode sum, ListNode tail, ListNode lhs, ListNode rhs, int overflow) {
        boolean isLeftEmpty = isEmpty(lhs);
        boolean isRightEmpty = isEmpty(rhs);
        boolean isOverflowed = overflow > 0;

        if (isLeftEmpty && isRightEmpty && !isOverflowed) {
            return sum;
        }

        ListNode node = new ListNode(0);

        if (!isLeftEmpty && !isRightEmpty) {
            int num = lhs.val + rhs.val + overflow;
            node.val = num % 10;
            overflow = num / 10;

            tail.next = node;
            return addTwoNumbersRecursive(sum, node, lhs.next, rhs.next, overflow);
        }

        if (!isLeftEmpty) {
            int num = lhs.val + overflow;
            node.val = num % 10;
            overflow = num / 10;

            tail.next = node;
            return addTwoNumbersRecursive(sum, node, lhs.next, null, overflow);
        }

        if (!isRightEmpty) {
            int num = rhs.val + overflow;
            node.val = num % 10;
            overflow = num / 10;

            tail.next = node;
            return addTwoNumbersRecursive(sum, node, null, rhs.next, overflow);
        }

        node.val = overflow;
        tail.next = node;

        return sum;
    }

    private static boolean isEmpty(ListNode head) {
        return head == null;
    }
}
