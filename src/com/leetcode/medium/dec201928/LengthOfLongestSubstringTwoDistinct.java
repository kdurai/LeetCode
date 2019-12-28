package com.leetcode.medium.dec201928;

/*
 * Program to find out length of longest substring with 2 distinct characters
 */
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct {

	public static void main(String[] args) {
		
		String s = "cababababc";
		
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));

	}

	 public static int lengthOfLongestSubstringTwoDistinct(String s) {
		 
		 Map<Character, Integer> map = new HashMap<>();

		 int start = 0, end = 0, len = s.length(), counter = 0;
		 int result = 0;
		 
		 while(end < len)
		 {
			 char c=s.charAt(end);
			 map.put(c, map.getOrDefault(c, 0) + 1);
			 if(map.get(c) == 1) counter++;
			 end++;
			 
			 while(counter > 2)
			 {
				char temp = s.charAt(start);
				map.put(temp, map.get(temp) - 1);
				if(map.get(temp) == 0)
					counter--;
				start++;
			 }
			 result = Math.max(result, end - start);
			 
		 }
		 
		 return result;
	 }
}
