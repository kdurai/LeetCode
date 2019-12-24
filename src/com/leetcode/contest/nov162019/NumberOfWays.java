package com.leetcode.contest.nov162019;

public class NumberOfWays {

	public static void main(String[] args) {

	}
	
	 private static int numberOfWays(int num_people) {
		 long catalan[] = new long[num_people / 2 + 2];
			catalan[0] = 1;
			catalan[1] = 1;
			for (int i = 2; i <= num_people / 2; i++) {
				catalan[i] = 0;
				for (int j = 0; j < i; j++) {
					catalan[i] = (catalan[i] + catalan[j] * catalan[i - j - 1] % 1000000007) % 1000000007;
				}
			}
			return (int) catalan[num_people / 2];
	 }

}
