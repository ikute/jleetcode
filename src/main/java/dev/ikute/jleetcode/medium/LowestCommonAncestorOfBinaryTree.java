package dev.ikute.jleetcode.medium;

/**
 * Lowest Common Ancestor of a Binary Tree problem.
 *
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">
 * Lowest Common Ancestor of a Binary Tree
 * </a>
 */
public class LowestCommonAncestorOfBinaryTree {

    static TreeNode findLowestAncestor(TreeNode tree, TreeNode p, TreeNode q) {
        if (tree == null) {
            return null;
        }

        if (tree.val == p.val && tree.val == q.val) {
            return tree;
        }

        TreeNode lnode = findLowestAncestor(tree.left, p, q);
        TreeNode rnode = findLowestAncestor(tree.right, p, q);

        if (lnode != null && rnode != null) {
            return tree;
        }

        return lnode != null ? lnode : rnode;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestAncestor(root, p, q);
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
