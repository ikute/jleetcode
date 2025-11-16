package dev.ikute.jleetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray Sum Equals K problem.
 *
 * @see <a href="https://leetcode.com/problems/subarray-sum-equals-k/">Subarray Sum Equals K</a>
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int cnt = 0;

        int[] psum = new int[nums.length];
        psum[0] = nums[0];
        for (int idx = 1; idx < nums.length; idx += 1) {
            psum[idx] = nums[idx] + psum[idx - 1];
        }

        Map<Integer, Integer> diffs = new HashMap<>();
        diffs.put(0, 1);

        for (int idx = 0; idx < psum.length; idx += 1) {
            int diff = psum[idx] - k;

            if (diffs.containsKey(diff)) {
                cnt += diffs.get(diff);
            }

            diffs.merge(psum[idx], 1, Integer::sum);
        }

        return cnt;
    }
}
