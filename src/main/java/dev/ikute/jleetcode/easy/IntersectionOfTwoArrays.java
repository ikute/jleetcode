package dev.ikute.jleetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Intersection of Two Arrays problem.
 *
 * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays/">Intersection of Two Arrays</a>
 */
public class IntersectionOfTwoArrays {

    static int[] intersect(int[] p1, int[] p2) {
        int[] numbuf = new int[1001];
        List<Integer> intersection = new ArrayList<>(
                Math.min(p1.length, p2.length)
        );

        for (int n : p1) {
            numbuf[n] = 1;
        }

        for (int n : p2) {
            if (numbuf[n] > 0) {
                intersection.add(n);
                numbuf[n] = 0;
            }
        }

        return intersection.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        return intersect(nums1, nums2);
    }
}
