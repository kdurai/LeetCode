package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 
Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 

Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
 

Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
 

Note:

All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.
 */
public class Compress {

	public static void main(String[] args) {

		char[] ch1 = {'a','a','b','b','c','c','c'};
		System.out.println(compress(ch1));
		char[] ch2 = {'a'};
		System.out.println(compress(ch2));
		char[] ch3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(compress(ch3));
		
	}
	
	private static int compress(char[] chars) {
		
		if(chars.length == 1)
			return 1;
		
        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(char c: chars)
        	if(map.containsKey(c))
        		map.put(c, map.get(c) + 1);
        	else
        		map.put(c, 1);
        
        for(Character ch: map.keySet()) {
        	list.add(ch + "");
        	int val = map.get(ch);
        	if(val > 1)
        	{
        		while(val > 9)
        			{
        				list.add((val%10) + "");
        				val = val/10;
        			}
        		list.add(val + "");
        	}
        }
        
        return list.size();

	}
	
	private static int compressAns(char[] chars) {

		int ansIndex = 0, index = 0;
		
		while(index < chars.length) {
			char currentChar = chars[index];
			int count = 0;
			
			while(index < chars.length && chars[index] == currentChar) {
				index++;
				count++;
			}
			
			chars[ansIndex++] = currentChar;
			
			if(count != 1) 
				for(char c: Integer.toString(count).toCharArray())
					chars[ansIndex++] = c;
		}
        
        return ansIndex;

	}
	
}
