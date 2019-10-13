package com.zalando.test;

public class BulbProblem {

	public static void main(String[] args) {

		int[] A = {1,3,4,5};
		
		System.out.println(solution(A));
	}

	private static int solution(int[] A) {
		int count = 0;
		int total = 0;
		
		for(int i=0; i < A.length; i++)
		{
			int sum = (i+1) * (i+2) / 2;
			total = total + A[i];
			
			if(sum == total)
			{
				count = count + 1;
			}
			
		}
		return count;
	}

}