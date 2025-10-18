package dev.ikute.jleetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Binary Tree Level Order Traversal problem.
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
 */
public class BinaryTreeLevelOrderTraversal {

    static List<List<Integer>> nodesLevelOrder(TreeNode tree) {
        List<List<Integer>> nodes = new ArrayList<>();

        if (tree == null) {
            return nodes;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(tree);
        for (; ; ) {
            int qsize = queue.size();

            if (qsize == 0) {
                break;
            }

            List<Integer> lnodes = new ArrayList<>(qsize);

            for (int idx = 0; idx < qsize; idx += 1) {
                TreeNode node = queue.pollFirst();

                lnodes.add(node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }

            nodes.add(lnodes);
        }

        return nodes;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        return nodesLevelOrder(root);
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
