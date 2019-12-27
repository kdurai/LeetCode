package com.leetcode.medium.dec201925;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will 
not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class FindAnagrams {

	public static void main(String[] args) {

		String s = "abab";
		String p = "ab";
		System.out.println(findAnagrams(s, p));
	}

	public static List<Integer> findAnagrams(String s, String p) {
	
		List<Integer> result = new ArrayList<>();
		
		if(p.length() > s.length())
			return result;
		
		Map<Character, Integer> map = new HashMap<>();
		
		char arr[] = p.toCharArray();
		
		for(char c: arr)
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		
		int left = 0, right = 0;
		int counter = map.size();
		
		char[] sarr = s.toCharArray();
		
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
				
				if(right - left == p.length())
					result.add(left);
				left++;
			}
		}
		
		return result;
	}

	
}
