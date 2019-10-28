package com.leetcode.problems;

/*
 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
public class CountPrimes {

	public static void main(String[] args) {

		int N = 10;
		System.out.println(countPrimes(N));
	}

	private static int countPrimes(int n) {
        
		boolean[] notPrime = new boolean[n];
		int count = 0;
		
		for(int i = 2; i < n; i++)
		{
			if(!notPrime[i]) {
				count++;
			for(int j = 2; j * i < n; j++)
				notPrime[i * j] = true;
			}
		}
			
		return count; 
    }
}
