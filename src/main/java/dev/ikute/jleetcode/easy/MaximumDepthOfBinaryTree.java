package dev.ikute.jleetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Maximum Depth of Binary Tree problem.
 *
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of Binary Tree</a>
 */
public class MaximumDepthOfBinaryTree {

    static int maxdepth(TreeNode tree) {
        int maxdepth = 0;

        Deque<TreeNodeDepth> stack = new ArrayDeque<>();
        if (tree != null) {
            stack.addLast(new TreeNodeDepth(tree, 1));
        }

        for (; ; ) {
            if (stack.isEmpty()) {
                break;
            }

            TreeNodeDepth marked = stack.pollLast();
            if (marked.depth > maxdepth) {
                maxdepth = marked.depth;
            }

            if (marked.node.right != null) {
                stack.addLast(new TreeNodeDepth(marked.node.right, marked.depth + 1));
            }

            if (marked.node.left != null) {
                stack.addLast(new TreeNodeDepth(marked.node.left, marked.depth + 1));
            }
        }

        return maxdepth;
    }

    public int maxDepth(TreeNode root) {
        return maxdepth(root);
    }

    public record TreeNodeDepth(
            TreeNode node,
            int depth
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
