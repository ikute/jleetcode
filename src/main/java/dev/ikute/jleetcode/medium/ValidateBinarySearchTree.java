package dev.ikute.jleetcode.medium;

/**
 * Validate Binary Search Tree problem.
 *
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 */
public class ValidateBinarySearchTree {

    static boolean isValidBstNode(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.left != null && (node.left.val <= min || node.left.val >= node.val)) {
            return false;
        }

        if (node.right != null && (node.right.val <= node.val || node.right.val >= max)) {
            return false;
        }

        return isValidBstNode(node.left, min, node.val)
                && isValidBstNode(node.right, node.val, max);
    }

    static boolean isValidBst(TreeNode bst) {
        if (bst == null) {
            return true;
        }

        if (bst.left != null && bst.left.val >= bst.val) {
            return false;
        }

        if (bst.right != null && bst.right.val <= bst.val) {
            return false;
        }

        return isValidBstNode(bst.left, Long.MIN_VALUE, bst.val)
                && isValidBstNode(bst.right, bst.val, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBst(root);
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
