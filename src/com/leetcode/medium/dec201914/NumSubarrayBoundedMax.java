package com.leetcode.medium.dec201914;

/*
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array 
element in that subarray is at least L and at most R.

Example :
Input: 
A = [2, 1, 4, 3]
L = 2
R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
Note:

L, R  and A[i] will be an integer in the range [0, 10^9].
The length of A will be in the range of [1, 50000].

 */
public class NumSubarrayBoundedMax {

	public static void main(String[] args) {

	}

	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
     
		int ans = 0;
		int i = 0;
		int count = 0;
		
		for(int j = 0;  j < A.length; j++ )
		{
			if(A[j] >= L && A[j] <= R)
			{
				ans += j - i + 1;
				count = j - i + 1;
			}
			else if(A[j] < L)
				ans += count;
			else {
				 i = j + 1;
				 count = 0;
			}
		}
		
		return ans;
    }
}
