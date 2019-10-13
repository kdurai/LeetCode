package com.leetcode.problems;

public class FlipAndInvertImage {

	public static void main(String[] args) {

		int[][] arr = {
				{1,1,0},
				{1,0,1},
				{0,0,0}
		};
		
		int[][] result = flipAndInvertImage(arr);
		
		System.out.println("[");
		for(int i =0;  i<arr.length; i++)
		{
			System.out.print("[");
			for(int j: arr[i])
				System.out.print(j + " ");
			System.out.println("]");
		}
		System.out.println("]");
	}

	private static int[][] flipAndInvertImage(int[][] A) {
        
		int C = A[0].length;
		
		for(int[] row : A)
		{
			System.out.println("Inside for1:" + row[0]);
			for(int i = 0; i < (C + 1)/2; i++) {
				int tmp = row[i] ^ 1;
				System.out.println("Inside for:" + row[i]);
				row[i] = row[C - 1 - i] ^ 1;
				row[C - 1 - i] = tmp;
			}
		}
		return A;
		
    }
}
