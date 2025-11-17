package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Top K Frequent Elements problem.
 *
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.merge(num, 1, Integer::sum);
        }

        List<List<Integer>> fnums = new ArrayList<>(nums.length);
        for (int idx = 0; idx <= nums.length; idx += 1) {
            fnums.add(new ArrayList<>());
        }

        for (int num : freqs.keySet()) {
            int freq = freqs.get(num);
            fnums.get(freq).add(num);
        }

        int[] top = new int[k];
        int idx = 0;
        for (int ijx = nums.length; ijx >= 0 && idx < k; ijx -= 1) {
            for (int num : fnums.get(ijx)) {
                top[idx] = num;
                idx += 1;

                if (idx >= k) {
                    break;
                }
            }
        }

        return top;
    }
}
