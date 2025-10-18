package dev.ikute.jleetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Binary Tree Postorder Traversal problem.
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">Binary Tree Postorder Traversal</a>
 */
public class BinaryTreePostorderTraversal {

    static List<Integer> nodesPostorder(TreeNode tree) {
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

            if (node.left != null) {
                stack.addLast(node.left);
            }

            if (node.right != null) {
                stack.addLast(node.right);
            }
        }

        return nodes.reversed();
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        return nodesPostorder(root);
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
