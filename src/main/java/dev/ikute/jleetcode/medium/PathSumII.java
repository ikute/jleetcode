package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Path Sum II problem.
 *
 * @see <a href="https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
 */
public class PathSumII {

    static List<List<Integer>> pathSum(TreeNodeSum tree, int target) {
        List<List<Integer>> rpaths = pathSumR(tree, target);
        return rpaths.stream().map(it -> it.reversed()).toList();
    }

    static List<List<Integer>> pathSumR(TreeNodeSum tree, int target) {
        if (tree.node.left == null && tree.node.right == null) {
            List<List<Integer>> paths = new ArrayList<>();

            if (tree.sum == target) {
                List<Integer> path = new ArrayList<>();
                path.add(tree.node.val);
                paths.add(path);
            }

            return paths;
        }

        List<List<Integer>> lpaths = null;
        List<List<Integer>> rpaths = null;

        if (tree.node.left != null) {
            lpaths = pathSumR(new TreeNodeSum(tree.node.left, tree.node.left.val + tree.sum), target);

            for (List<Integer> path : lpaths) {
                path.add(tree.node.val);
            }
        }

        if (tree.node.right != null) {
            rpaths = pathSumR(new TreeNodeSum(tree.node.right, tree.node.right.val + tree.sum), target);

            for (List<Integer> path : rpaths) {
                path.add(tree.node.val);
            }
        }

        if (lpaths != null && rpaths != null) {
            return Stream.concat(lpaths.stream(), rpaths.stream()).toList();
        }

        if (lpaths != null) {
            return lpaths;
        }

        if (rpaths != null) {
            return rpaths;
        }

        return new ArrayList<>();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        return pathSum(new TreeNodeSum(root, root.val), targetSum);
    }

    public record TreeNodeSum(
            TreeNode node,
            int sum
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
