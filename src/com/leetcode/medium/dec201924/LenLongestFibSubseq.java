package com.leetcode.medium.dec201924;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:

n >= 3
X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
Given a strictly increasing array A of positive integers forming a sequence, find the length of the
 longest fibonacci-like subsequence of A.  If one does not exist, return 0.

(Recall that a subsequence is derived from another sequence A by deleting any number of elements
 (including none) from A, without changing the order of the remaining elements.  For example, [3, 5,
  8] is a subsequence of [3, 4, 5, 6, 7, 8].)

Example 1:

Input: [1,2,3,4,5,6,7,8]
Output: 5
Explanation:
The longest subsequence that is fibonacci-like: [1,2,3,5,8].
Example 2:

Input: [1,3,7,11,12,14,18]
Output: 3
Explanation:
The longest subsequence that is fibonacci-like:
[1,11,12], [3,11,14] or [7,11,18].
 
Note:

3 <= A.length <= 1000
1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
(The time limit has been reduced by 50% for submissions in Java, C, and C++.)

 */

public class LenLongestFibSubseq {

	public static void main(String[] args) {

		int[] arr = {1,3,7,11,12,14,18};
		System.out.println(lenLongestFibSubseq(arr));
	}

	public static int lenLongestFibSubseq(int[] A) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int a : A)
			set.add(a);
		
		int res = 2;
		int len = A.length;
		
		for(int i = 0; i < len; i++ )
			for(int j = i + 1; j < len; j++)
			{
				int a = A[i], b = A[j], l = 2;
				
				while(set.contains(a + b))
				{
					b = a + b;
					a = b - a;
					l++;
				}
				
				res = Math.max(res, l);
			}
		
		return res > 2 ? res : 0;
    }
}
