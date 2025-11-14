package dev.ikute.jleetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Continuous Subarray Sum problem.
 *
 * @see <a href="https://leetcode.com/problems/continuous-subarray-sum/">Continuous Subarray Sum</a>
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int psum = 0;

        Map<Integer, Integer> rms = new HashMap<>(nums.length);
        rms.put(0, -1);

        for (int idx = 0; idx < nums.length; idx += 1) {
            psum += nums[idx];
            int rm = psum % k;

            if (rms.containsKey(rm)) {
                int irx = rms.get(rm);
                if (idx - irx > 1) {
                    return true;
                }
            } else {
                rms.put(rm, idx);
            }
        }

        return false;
    }
}
