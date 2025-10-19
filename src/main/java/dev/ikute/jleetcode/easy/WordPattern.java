package dev.ikute.jleetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern problem.
 *
 * @see <a href="https://leetcode.com/problems/word-pattern/">Word Pattern</a>
 */
public class WordPattern {

    static boolean isMatches(String s, String pattern) {
        Map<String, Character> smap = HashMap.newHashMap(pattern.length());
        int[] pchars = new int[128];

        int isx = 0;
        int ipx = 0;
        for (; ; ) {
            if (isx >= s.length()) {
                return ipx >= pattern.length();
            }

            if (ipx >= pattern.length()) {
                return false;
            }

            int wlen = 0;
            for (; ; ) {
                if (isx + wlen >= s.length()) {
                    break;
                }

                if (s.charAt(isx + wlen) == ' ') {
                    break;
                }

                wlen += 1;
            }

            String word = s.substring(isx, isx + wlen);
            if (smap.containsKey(word)) {
                char sch = smap.get(word);
                char pch = pattern.charAt(ipx);

                if (sch != pch) {
                    return false;
                }
            } else {
                char pch = pattern.charAt(ipx);

                if (pchars[pch] > 0) {
                    return false;
                }

                smap.put(word, pch);
                pchars[pch] = 1;
            }

            isx += wlen + 1;
            ipx += 1;
        }
    }

    public boolean wordPattern(String pattern, String s) {
        return isMatches(s, pattern);
    }
}
