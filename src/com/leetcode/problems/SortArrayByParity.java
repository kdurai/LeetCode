package com.leetcode.problems;

import java.util.Arrays;

public class SortArrayByParity {

	public static void main(String[] args) {

		int[] arr = { 1,2,3,4,5,6};
		
		System.out.println(Arrays.toString(sortArrayByParity(arr)));
	}

	private static int[] sortArrayByParity(int[] A) {

		for(int i = 0, j = 0; j < A.length; j++)
		{
			if(A[j] % 2 == 0)
			{
				int temp = A[i];
				A[i++] = A[j];
				A[j] = temp;
			}
		}
		
		return A;
		
		 /* return Arrays.stream(A)
        .boxed()
        .sorted((a,b) -> Integer.compare(a%2, b%2))
        .mapToInt(i -> i)
        .toArray(); */
	}

}
