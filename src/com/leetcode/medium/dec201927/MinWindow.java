package com.leetcode.medium.dec201927;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the 
 * characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum 
window in S.

 */
public class MinWindow {

	public static void main(String[] args) {

		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		System.out.println(minWindow(s, t));
	}

	public static String minWindow(String s, String t) {
		
		if(t.length() > s.length())
			return "";
		
		Map<Character, Integer> map = new HashMap<>();
		
		char arr[] = t.toCharArray();
		
		for(char c: arr)
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		int left = 0, right = 0;
		int counter = map.size();
		char[] sarr = s.toCharArray();
		
		int len = Integer.MAX_VALUE;
		int head = left;
		
		while(right < s.length())
		{
			if(map.containsKey(sarr[right]))
			{
				map.put(sarr[right], map.get(sarr[right]) - 1);
				if(map.get(sarr[right]) == 0) counter--;
			}
			right++;
			while(counter == 0 )
			{
				char c = sarr[left];
				
				if(map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
					if(map.get(c) > 0)
						counter++;
				}
				
				if(right - left < len)
				{
					len = right - left;
					head = left;
				}
				
				left++;
			}
		}

		if(len == Integer.MAX_VALUE)
			return "";
		return s.substring(head, head+len);
    }
}
