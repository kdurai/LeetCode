package com.leetcode.problems;

public class RepeatedNTimes {

	public static void main(String[] args) {
		
		//int[] arr = {5,1,5,2,5,3,5,4};
		int[] arr = {1,2,3,4};
		System.out.println(repeatedNTimes(arr));
	}

	private static int repeatedNTimes(int[] A) {
        
		for(int i = 2; i < A.length; i++) {
			if(A[i] == A[i-1] || A[i] == A[i-2])
				return A[i];
		}
		
		throw null;
    }
}
