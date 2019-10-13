package com.leetcode.problems;

/*
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
 */
public class JewelsAndStones {

	public static void main(String[] args) {

		System.out.println(JewelsAndStones("aA", "aAAbbbb"));
		System.out.println(JewelsAndStones("z", "ZZ"));
		
	}

	public static int JewelsAndStones(String jewels, String stones) {

		char[] jewelarr = jewels.toCharArray();
		char[] stonearr = stones.toCharArray();
		int count = 0;
		
		for(int i = 0; i < jewelarr.length; i++)
		{
			for(int j = 0; j < stonearr.length; j++)
			{
				if(jewelarr[i] == stonearr[j])
					count++;
			}
		}
		return count;
		
		//return S.replaceAll("[^" + J + "]", "").length();
	}
}
