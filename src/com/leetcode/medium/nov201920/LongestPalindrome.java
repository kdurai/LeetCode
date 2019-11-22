package com.leetcode.medium.nov20191120;

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the 
 * maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

 */
public class LongestPalindrome {

	private static int start, end;
	
	public static void main(String[] args) {

		String str = "babad";
		System.out.println(longestPalindrome(str));
	}
	
	private static String longestPalindrome(String s) {
    
		int length = s.length();
		
		if(length < 2)
			return s;
		
		for(int i = 0; i < s.length()-1; i++)
		{
			extendPalindrome(s, i, i);
			extendPalindrome(s, i, i+1);
		}
		
		return s.substring(start, start+end);
    }

	private static void extendPalindrome(String s, int i, int j) {
		
		while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j) )
		{
			i--;
			j++;
		}
		
		if(end < j - i -1) 
		{
			start = i + 1;
			end = j - i -1;
		}
	}

}
