package dev.ikute.jleetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Binary Tree Preorder Traversal problem.
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Binary Tree Preorder Traversal</a>
 */
public class BinaryTreePreorderTraversal {

    static List<Integer> nodesPreorder(TreeNode tree) {
        List<Integer> nodes = new ArrayList<>();

        if (tree == null) {
            return nodes;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(tree);
        for (; ; ) {
            if (stack.isEmpty()) {
                break;
            }

            TreeNode node = stack.pollLast();
            nodes.add(node.val);

            if (node.right != null) {
                stack.addLast(node.right);
            }

            if (node.left != null) {
                stack.addLast(node.left);
            }
        }

        return nodes;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return nodesPreorder(root);
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
