package dev.ikute.jleetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Max Number of K-Sum Pairs problem.
 *
 * @see <a href="https://leetcode.com/problems/max-number-of-k-sum-pairs/">Max Number of K-Sum Pairs</a>
 */
public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        int upairs = 0;

        Map<Integer, Integer> remains = new HashMap<>(nums.length);
        for (int num : nums) {
            int remain = k - num;

            if (remains.containsKey(remain)) {
                upairs += 1;

                if (remains.get(remain) == 1) {
                    remains.remove(remain);
                } else {
                    remains.merge(remain, -1, Integer::sum);
                }
            } else {
                remains.merge(num, 1, Integer::sum);
            }
        }

        return upairs;
    }
}
