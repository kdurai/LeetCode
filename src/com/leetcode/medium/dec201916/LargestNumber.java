package com.leetcode.medium.dec201916;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

 */
public class LargestNumber {

	public static void main(String[] args) {

	}

	public String largestNumber(int[] nums) {
    
		if(nums == null || nums.length == 0)
			return "";
		
		String[] snums = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
		

		Comparator<String> comp = (s1, s2) -> {
			String str1 = s1 + s2;
			String str2 = s2 + s1;
			return str2.compareTo(str1);
		};

		Arrays.sort(snums, comp);
		
		if(snums[0].equals("0"))
			return "0";
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < snums.length; i++)
			sb.append(snums[i]);
		
		return sb.toString();
    }
	
}
