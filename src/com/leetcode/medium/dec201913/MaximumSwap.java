package com.leetcode.medium.dec201913;

/*
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued
 *  number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: 9973
Output: 9973
Explanation: No swap.

Note: 
The given number is in the range [0, 108]

 */
public class MaximumSwap {

	public static void main(String[] args) {

		int num = 2736;
		
		System.out.println(maximumSwap(num));;
	}

	public static int maximumSwap(int num) {
		
		char[] input = Integer.toString(num).toCharArray();
		int n = input.length;
		
		int[] buckets = new int[10];
		
		for(int i = 0 ; i < input.length; i++)
			buckets[input[i] - '0'] = i;
		
		for(int i = 0 ; i < n; i++)
			for(int j = 9; j > input[i] - '0'; j--)
				if(buckets[j] > i){
					char temp = input[i];
					input[i] = input[buckets[j]];
					input[buckets[j]] = temp;
					
					return Integer.valueOf(new String(input));
				}

		
		return num;
    }
}
