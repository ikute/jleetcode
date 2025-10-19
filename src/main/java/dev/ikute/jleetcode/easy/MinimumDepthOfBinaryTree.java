package dev.ikute.jleetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Minimum Depth of Binary Tree problem.
 *
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
 */
public class MinimumDepthOfBinaryTree {

    static int mindepth(TreeNode tree) {
        Deque<TreeNodeDepth> queue = new ArrayDeque<>();

        if (tree != null) {
            queue.addLast(new TreeNodeDepth(tree, 1));
        }

        for (; ; ) {
            int qsize = queue.size();

            if (qsize == 0) {
                return 0;
            }

            for (int idx = 0; idx < qsize; idx += 1) {
                TreeNodeDepth marked = queue.pollFirst();

                if (marked.node.left == null && marked.node.right == null) {
                    return marked.depth;
                }

                if (marked.node.left != null) {
                    queue.addLast(new TreeNodeDepth(marked.node.left, marked.depth + 1));
                }

                if (marked.node.right != null) {
                    queue.addLast(new TreeNodeDepth(marked.node.right, marked.depth + 1));
                }
            }
        }
    }

    public int minDepth(TreeNode root) {
        return mindepth(root);
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
