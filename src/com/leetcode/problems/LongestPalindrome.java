package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string which consists of lowercase or uppercase letters, find the length of the 
 * longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

 */
public class LongestPalindrome {

	public static void main(String[] args) {

		String str = "abccccdd";
		System.out.println(longestPalindrome(str));
		System.out.println(longestPalindromeHashSet(str));
	}

	private static int longestPalindrome(String s) {
		
		int[] count = new int[128];
		for(char c: s.toCharArray())
			count[c]++;
		
		int ret = 0;
		for(int v : count) 
		{
			ret += v/2 * 2;
			if(ret %2 == 0 && v %2 == 1)
				ret++;
		}
		
		return ret;
		
    }
	
	private static int longestPalindromeHashSet(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int count = 0;
		Set<Character> set = new HashSet<>();
		
		for(char c : s.toCharArray())
		{
			if(set.contains(c))
			{
				set.remove(c);
				count++;
			}
			else
				set.add(c);
		}
		
		if(!set.isEmpty()) 
			return count * 2 + 1;
		else
			return count * 2;
	}
}
