package com.leetcode.medium.dec201913;

/*
 * Your are given an array of integers prices, for which the i-th element is the price of a given
 *  stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each
 transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock
  share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.

 */
public class MaxProfit {

	public static void main(String[] args) {

		int[] prices = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		
		System.out.println(maxProfit(prices, fee));
	}

	public static int maxProfit(int[] prices, int fee) {
		
		int profit = 0;
		
		int n = prices.length;
		int maxSoFar = 0, max = 0;
		
		for(int i = 0; i < n; i++ )
		{
			max += prices[i];
			maxSoFar = Math.max(maxSoFar, Math.max(max, prices[i]));
		}
		
		System.out.println(maxSoFar);
		return profit;
    }
}
