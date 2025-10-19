package dev.ikute.jleetcode.easy;

/**
 * Symmetric Tree problem.
 *
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Symmetric Tree</a>
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricNodes(root.left, root.right);
    }

    static boolean isSymmetricNodes(TreeNode lnode, TreeNode rnode) {
        if (lnode == null && rnode == null) {
            return true;
        }

        if (lnode == null || rnode == null) {
            return false;
        }

        return lnode.val == rnode.val
                && isSymmetricNodes(lnode.left, rnode.right)
                && isSymmetricNodes(lnode.right, rnode.left);
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
