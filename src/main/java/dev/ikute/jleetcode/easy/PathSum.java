package dev.ikute.jleetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Path Sum problem.
 *
 * @see <a href="https://leetcode.com/problems/path-sum/">Path Sum</a>
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        Deque<TreeNodeSum> queue = new ArrayDeque<>();
        if (root != null) {
            queue.addLast(new TreeNodeSum(root, root.val));
        }

        for (; ; ) {
            int qsize = queue.size();

            if (qsize == 0) {
                return false;
            }

            for (int idx = 0; idx < qsize; idx += 1) {
                TreeNodeSum marked = queue.pollFirst();

                if (marked.node.left == null && marked.node.right == null) {
                    if (marked.sum == targetSum) {
                        return true;
                    }
                }

                if (marked.node.left != null) {
                    queue.addLast(new TreeNodeSum(marked.node.left, marked.sum + marked.node.left.val));
                }

                if (marked.node.right != null) {
                    queue.addLast(new TreeNodeSum(marked.node.right, marked.sum + marked.node.right.val));
                }
            }
        }
    }

    public record TreeNodeSum(
            TreeNode node,
            int sum
    ) {
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
