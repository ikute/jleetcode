package dev.ikute.jleetcode.hard;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Median of Two Sorted Arrays problem
 *
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays">Median of Two Sorted Arrays</a>
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] fst, int[] scnd) {
        MergedArray array = new MergedArray(fst, scnd);
        int md = array.length / 2;

        if (array.length % 2 == 0) {
            int idx = 0;
            Iterator<Integer> iter = array.iterator();

            for (; ; ) {
                int lnext = iter.next();

                if (idx == md - 1) {
                    int rnext = iter.next();
                    return ((double) (lnext + rnext)) / 2;
                }

                idx += 1;
            }
        } else {
            int idx = 0;
            Iterator<Integer> iter = array.iterator();

            for (; ; ) {
                int next = iter.next();

                if (idx == md) {
                    return next;
                }

                idx += 1;
            }
        }
    }
}

class MergedArray implements Iterable<Integer> {
    final int[] fst;
    final int[] scnd;
    final int length;

    MergedArray(int[] fst, int[] scnd) {
        this.fst = fst;
        this.scnd = scnd;
        this.length = fst.length + scnd.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MergedArrayIterator(this);
    }
}

class MergedArrayIterator implements Iterator<Integer> {

    private final MergedArray array;
    private int fidx;
    private int sidx;

    MergedArrayIterator(MergedArray array) {
        this.array = array;
        this.fidx = 0;
        this.sidx = 0;
    }

    @Override
    public boolean hasNext() {
        return fidx + sidx < array.length;
    }

    @Override
    public Integer next() {
        if (fidx == array.fst.length && sidx == array.scnd.length) {
            throw new NoSuchElementException();
        }

        if (fidx == array.fst.length) {
            int next = array.scnd[sidx];
            sidx += 1;
            return next;
        }

        if (sidx == array.scnd.length) {
            int next = array.fst[fidx];
            fidx += 1;
            return next;
        }

        boolean isFirstNext = array.fst[fidx] < array.scnd[sidx];
        int next;
        if (isFirstNext) {
            next = array.fst[fidx];
            fidx += 1;
        } else {
            next = array.scnd[sidx];
            sidx += 1;
        }
        return next;
    }
}
