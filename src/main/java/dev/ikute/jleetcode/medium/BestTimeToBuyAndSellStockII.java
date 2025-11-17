package dev.ikute.jleetcode.medium;

/**
 * Best Time to Buy and Sell Stock II problem.
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time to Buy and Sell Stock II</a>
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int idx = 1; idx < prices.length; idx += 1) {
            profit += Math.max(0, prices[idx] - prices[idx - 1]);
        }

        return profit;
    }
}
