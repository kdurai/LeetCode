package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

	public static void main(String[] args) {

		int left = 2;
		int right = 22;
		
		System.out.println(selfDividingNumbers(left, right));
	}
	
	private static List<Integer> selfDividingNumbers(int left, int right) {
        
		List<Integer> list = new ArrayList<>();
		for(int i = left; i <= right; i++) {
			int j = i;
			for(;j > 0; j/=10)
				if( (j % 10 == 0) || (i % (j % 10) != 0) ) break;
			
			if(j == 0) list.add(i);
		}
		
		return list;
    }

}
