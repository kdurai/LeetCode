package com.leetcode.medium.dec201916;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: 
 * "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within
 *  the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once 
in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]

 */
public class FindRepeatedDnaSequences {

	public static void main(String[] args) {

	}

	public List<String> findRepeatedDnaSequences(String s) {
        
		Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
		
		for(int i = 0 ; i+9 < s.length(); i++)
		{
			String temp = s.substring(i, i+10);
			if(seen.contains(temp))
				repeated.add(temp);
			seen.add(temp);
		}
		
	 return new ArrayList<>(repeated);
	 
    }
}
