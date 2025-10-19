package dev.ikute.jleetcode.easy;

/**
 * Same Tree problem.
 *
 * @see <a href="https://leetcode.com/problems/same-tree/">Same Tree</a>
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameNodes(p, q);
    }

    static boolean isSameNodes(TreeNode lnode, TreeNode rnode) {
        if (lnode == null && rnode == null) {
            return true;
        }

        if (lnode == null || rnode == null) {
            return false;
        }

        return lnode.val == rnode.val
                && isSameNodes(lnode.left, rnode.left)
                && isSameNodes(lnode.right, rnode.right);
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
