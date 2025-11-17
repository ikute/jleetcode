package dev.ikute.jleetcode.easy;

/**
 * Best Time to Buy and Sell Stock problem.
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a>
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;

        for (int idx = 1; idx < prices.length; idx += 1) {
            if (prices[idx] < buy) {
                buy = prices[idx];
            } else if (prices[idx] - buy > sell) {
                sell = prices[idx] - buy;
            }
        }

        return sell;
    }
}
