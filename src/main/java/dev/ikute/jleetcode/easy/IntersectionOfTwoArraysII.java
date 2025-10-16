package dev.ikute.jleetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Intersection of Two Arrays II problem.
 *
 * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">Intersection of Two Arrays II</a>
 */
public class IntersectionOfTwoArraysII {

    static int[] findIntersection(int[] p1, int[] p2) {
        int[] numbuf = new int[1001];
        List<Integer> intersection = new ArrayList<>(
                Math.min(p1.length, p2.length)
        );

        for (int n : p1) {
            numbuf[n] += 1;
        }

        for (int n : p2) {
            if (numbuf[n] > 0) {
                intersection.add(n);
                numbuf[n] -= 1;
            }
        }

        return intersection.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        return findIntersection(nums1, nums2);
    }
}
