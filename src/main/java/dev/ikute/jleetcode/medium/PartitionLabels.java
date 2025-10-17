package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition Labels problem.
 *
 * @see <a href="https://leetcode.com/problems/partition-labels/">Partition Labels</a>
 */
public class PartitionLabels {

    static List<Integer> partition(String s) {
        List<Integer> labels = new ArrayList<>();

        int[] buf = new int[26];
        for (int idx = 0; idx < s.length(); idx += 1) {
            int ch = s.charAt(idx) - 'a';
            buf[ch] = idx;
        }

        int lhs = 0;
        int rhs = 0;
        for (int idx = 0; idx < s.length(); idx += 1) {
            int ch = s.charAt(idx) - 'a';

            rhs = Math.max(rhs, buf[ch]);
            if (rhs == idx) {
                labels.add(rhs - lhs + 1);
                lhs = rhs + 1;
            }
        }

        return labels;
    }

    public List<Integer> partitionLabels(String s) {
        return partition(s);
    }
}
