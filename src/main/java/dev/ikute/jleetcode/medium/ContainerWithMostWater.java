package dev.ikute.jleetcode.medium;

/**
 * Container With Most Water problem.
 *
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water</a>
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int lhs = 0, rhs = height.length - 1;
        int maxv = 0;

        for (; ; ) {
            if (lhs >= rhs) {
                return maxv;
            }

            maxv = Math.max(maxv, (rhs - lhs) * Math.min(height[lhs], height[rhs]));
            if (height[lhs] <= height[rhs]) {
                lhs += 1;
            } else {
                rhs -= 1;
            }
        }
    }
}
