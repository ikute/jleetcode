package dev.ikute.jleetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Binary Tree Inorder Traversal problem.
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">Binary Tree Inorder Traversal</a>
 */
public class BinaryTreeInorderTraversal {

    static List<Integer> nodesInorder(TreeNode tree) {
        List<Integer> nodes = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = tree;
        for (; ; ) {
            if (node == null && stack.isEmpty()) {
                break;
            }

            for (; ; ) {
                if (node == null) {
                    break;
                }

                stack.addLast(node);
                node = node.left;
            }

            node = stack.pollLast();
            nodes.add(node.val);
            node = node.right;
        }

        return nodes;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return nodesInorder(root);
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
