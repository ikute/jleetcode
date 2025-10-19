package dev.ikute.jleetcode.easy;

/**
 * Isomorphic Strings problem.
 *
 * @see <a href="https://leetcode.com/problems/isomorphic-strings/">Isomorphic Strings</a>
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] smap = new int[128];
        int[] tmap = new int[128];

        for (int idx = 0; idx < s.length(); idx += 1) {
            int sch = s.charAt(idx);
            int tch = t.charAt(idx);

            if (smap[sch] == 0 && tmap[tch] == 0) {
                smap[sch] = tch;
                tmap[tch] = sch;
            } else if (smap[sch] != tch) {
                return false;
            }
        }

        return true;
    }
}
