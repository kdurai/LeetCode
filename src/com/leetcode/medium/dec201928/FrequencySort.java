package com.leetcode.medium.dec201928;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

 */
public class FrequencySort {

	public static void main(String[] args) {

		String s = "tree";
		System.out.println(frequencySort(s));
	}

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		char[] charr = s.toCharArray();
		for(char c: charr)
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		Comparator<Entry<Character, Integer>> entryComparator
			= new Comparator<Map.Entry<Character, Integer>>() {
				@Override
				public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
					int val1 = o1.getValue();
					int val2 = o2.getValue();
					return val2 - val1;
				}
		};
		
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(set);
		Collections.sort(list, entryComparator);
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character, Integer> entry : list)
		{
			char ch = entry.getKey();
			int frequency = entry.getValue();
			
			for(int i = 0 ; i < frequency; i++)
				sb.append(ch);
		}
		
		return sb.toString();
	}
}
