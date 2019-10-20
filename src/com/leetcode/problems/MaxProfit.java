package com.leetcode.problems;

/*
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 */
public class MaxProfit {

	public static void main(String[] args) {

		int[] arr = {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));
		System.out.println(myMaxProfit(arr));
	}
	
	 private static int maxProfit(int[] prices) {
	     
		 int minIndex = 0, maxIndex = 0;
		 int min = prices[0];
		 int max = prices[0];
		 
		 for(int i = 1; i < prices.length; i++) {
			 if(min > prices[i]) 
				 {
				 min = max = prices[i];
				 minIndex = i;
				 }
			 
			 if(max < prices[i]) 
				 {
				 	max = prices[i];
				 	maxIndex = i;
				 }
		 }
		 
		 return minIndex < maxIndex ? max - min : 0;
	 }
	 
	 private static int myMaxProfit(int[] prices) {
		 int maxCurr = 0 , maxSoFar = 0;
		 
		 for(int i = 1; i < prices.length; i++) {
			 maxCurr = Math.max(0,  maxCurr += prices[i] - prices[i-1]);
			 maxSoFar = Math.max(maxCurr,  maxSoFar);
		 }
		 
		 return maxSoFar;
	 }

	 private static int myMaxProfit2(int[] prices) {
		 int profit = 0, min = 0;
		 
		 for(int i = 1; i < prices.length; i++)
		 {
			 if(prices[i] > prices[i-1]) continue;
			 profit = profit  + prices[i-1] - prices[min];
			 min = i;
		 }
		 
		 profit = profit + prices[prices.length - 1] - prices[min];
		 
		 return profit;
	 }

}
