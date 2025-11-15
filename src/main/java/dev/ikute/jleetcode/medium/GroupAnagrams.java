package dev.ikute.jleetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams problem.
 *
 * @see <a href="https://leetcode.com/problems/group-anagrams/">Group Anagrams</a>
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();

            Arrays.sort(chars);
            String gkey = String.valueOf(chars);

            if (groups.containsKey(gkey)) {
                List<String> group = groups.get(gkey);
                group.add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);

                groups.put(gkey, group);
            }
        }

        return groups.values().stream().toList();
    }
}
