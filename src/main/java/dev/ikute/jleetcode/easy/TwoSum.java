package dev.ikute.jleetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum problem.
 *
 * @see <a href="https://leetcode.com/problems/two-sum">Two Sum</a>
 */
public class TwoSum {

    private static final int[] ZERO_ONE = {0, 1};

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return ZERO_ONE;
        }

        Map<Integer, Integer> subs = HashMap.newHashMap(nums.length);
        for (int i = 0; i < nums.length; i += 1) {
            int diff = target - nums[i];

            if (subs.containsKey(diff)) {
                return new int[]{subs.get(diff), i};
            }

            subs.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
