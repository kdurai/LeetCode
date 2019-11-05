package com.leetcode.problems;

/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqChar {

	public static void main(String[] args) {

		String str = "leetcode";
		System.out.println(firstUniqChar(str));
		str = "loveleetcode";
		System.out.println(firstUniqChar(str));
	}

	private static int firstUniqChar(String s) {
		
		int[] occurance = new int[26];
		
		for(int i = 0; i < s.length(); i++)
			occurance[s.charAt(i) - 'a']++;

		for(int i = 0; i < s.length(); i++)
			if(occurance[s.charAt(i) - 'a'] == 1)
				return i;
		
		return -1;
    }
}
