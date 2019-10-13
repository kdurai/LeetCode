package com.leetcode.problems;

public class MySqrt {

	public static void main(String[] args) {

		int x = 144;
		
		System.out.println(mySqrt(x));
	}
	
	private static int mySqrt(int x) {
		long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
	}
	
	private static int mySqrt1(int x) {
        
		 if (x == 0)
		        return 0;
		 
		 int left = 1, right = Integer.MAX_VALUE;

		 while (true) {
		    int mid = left + (right - left)/2;
		    if (mid > x/mid) {
		       right = mid - 1;
		     } else {
		    	 	if (mid + 1 > x/(mid + 1))
		                return mid;
		            left = mid + 1;
		        }
		   
		 }
    }

}
