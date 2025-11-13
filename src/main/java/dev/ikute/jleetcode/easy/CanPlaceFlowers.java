package dev.ikute.jleetcode.easy;

/**
 * Can Place Flowers problem.
 *
 * @see <a href="https://leetcode.com/problems/can-place-flowers/">Can Place Flowers</a>
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int p = 0;
        int k = 0;

        for (; ; ) {
            if (k >= n) {
                return true;
            }

            if (p >= flowerbed.length) {
                return false;
            }

            int pt = p + 1;
            for (; pt < flowerbed.length && flowerbed[pt] == 1; ) {
                pt += 1;
            }

            if (pt == p + 1) {
                if (flowerbed[p] == 0 && (pt >= flowerbed.length || flowerbed[pt] == 0)) {
                    k += 1;
                }

                p += 2;
            } else {
                p = pt + 1;
            }
        }
    }
}
