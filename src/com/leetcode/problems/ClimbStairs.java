package com.leetcode.problems;

public class ClimbStairs {

	public static void main(String[] args) {

		int n = 4;
		System.out.println(climbStairs(n));
	}

	private static int climbStairs(int n) {
        if(n == 0)
        	return 0;
        
        if(n == 1)
        	return 1;
        
        if(n == 2)
        	return 2;
        
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        int i = 3;
        
        while(i <= n)
        {
        	dp[i] = dp[i-1] + dp[i-2];
        	i = i + 1;
        }
        
        return dp[n];
    }
}
