package com.leetcode.medium.nov201924;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

 */
public class Partition {

	public static void main(String[] args) {
		String s = "aab";
		
		List<List<String>> result = partition(s);
		
		System.out.println("Main");
		for(List<String> list : result)
			System.out.println(list);
		
	}

	private static List<List<String>> partition(String s) {
		
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

	private static void backtrack(List<List<String>> result, List<String> list, String s, int start) {
		
		if(start == s.length())
			result.add(new ArrayList<>(list));
		else
			for(int i = start; i < s.length(); i++)
			{
				if(isPalindrome(s, start, i))
				{
					list.add(s.substring(start, i+1));
					backtrack(result, list, s, i+1);
					list.remove(list.size() - 1);
				}
			}
	}

	private static boolean isPalindrome(String s, int start, int end) {
		while(start < end  )
			if(s.charAt(start++) != s.charAt(end--)) 
				return false;
		
		return true;
	}
	
}
