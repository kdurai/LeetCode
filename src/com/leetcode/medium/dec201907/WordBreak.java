package com.leetcode.medium.dec201907;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine
 *  if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

 */
public class WordBreak {

	public static void main(String[] args) {
		String str = "leetcode";
		List<String> list = new ArrayList<>();
		list.add("leet");
		list.add("code");
		
		System.out.println(wordBreak(str, list));
	}

	private static boolean wordBreak(String s, List<String> wordDict) {
		
		int n = wordDict.size();
		int len = s.length();
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		for(int i = 1; i <= len; i++)
			for(int j = 0; j < i; j++ )
			{
				System.out.println("s.substring(" + j + ", " +i + ") = " + s.substring(j, i));
				if(dp[j] && wordDict.contains(s.substring(j, i)))
						{
							dp[i] = true;
							break;
						}
			}
		return dp[len];
    }
}
