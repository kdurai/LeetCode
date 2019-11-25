package com.leetcode.contest.nov201924;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at
 *  most three product names from products after each character of searchWord is typed. Suggested products
 *   should have common prefix with the searchWord. If there are more than three products with a common
 *    prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed. 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]

Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]

Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]

Constraints:

1 <= products.length <= 1000
1 <= Σ products[i].length <= 2 * 10^4
All characters of products[i] are lower-case English letters.
1 <= searchWord.length <= 1000
All characters of searchWord are lower-case English letters.
 * 
 * 
 */

import java.util.List;

public class SuggestedProducts {

	public static void main(String[] args) {
		
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mouse";
		 
		 
		/* String[] products = {"havana"}; String searchWord = "havana"; */ 
		 
		/*
		 * String[] products = {"bags","baggage","banner","box","cloths"}; String
		 * searchWord = "bags";
		 */
		 
		/*
		 * String[] products = {"havana"}; String searchWord = "tatiana";
		 */
		
		List<List<String>> result = suggestedProducts(products, searchWord);
		
		for(List<String> list : result)
			System.out.println(list);
	}

	private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		
		Arrays.sort(products);
        int l = 0, r = products.length;
        List<List<String>> gans = new ArrayList<>();
        for(int i = 0;i < searchWord.length();i++){
        	while(l < products.length &&
        			(products[l].length() <= i || products[l].charAt(i) < searchWord.charAt(i))){
        		l++;
        	}
        	while(r >= 1 &&
        			(products[r-1].length() <= i || products[r-1].charAt(i) > searchWord.charAt(i))){
        		r--;
        	}
        	List<String> ans = new ArrayList<>();
        	for(int k = 0;k < 3 && l+k < r;k++){
        		ans.add(products[l+k]);
        	}
        	gans.add(ans);
        }
        return gans;
		
	    }

	private static void backtrack(List<List<String>> result, List<String> list, String[] products, 
			String searchWord, int start) {
		
		if(start > 0)
		{
			result.add(new ArrayList<>(list));
			list.clear();
		}
		
		if(start == searchWord.length())
			return;
		
		for(int j = 0, count = 0; count < 3 && j < products.length && (start+1) <= products[j].length(); j++)
			if(searchWord.substring(0, start+1).equals(products[j].substring(0, start+1)))
				{
					list.add(products[j]);
					count++;
				}
			
		backtrack(result, list, products, searchWord, start+1);
		
	}
}
