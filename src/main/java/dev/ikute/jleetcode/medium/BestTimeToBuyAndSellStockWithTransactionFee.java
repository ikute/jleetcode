package dev.ikute.jleetcode.medium;

/**
 * Best Time to Buy and Sell Stock with Transaction Fee problem.
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">
 * Best Time to Buy and Sell Stock with Transaction Fee
 * </a>
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int bp = Integer.MIN_VALUE;
        int sp = 0;

        for (int price : prices) {
            bp = Math.max(bp, sp - price);
            sp = Math.max(sp, bp + price - fee);
        }

        return sp;
    }
}
