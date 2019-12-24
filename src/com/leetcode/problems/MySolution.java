package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class MySolution {
	
	private final int min;
	
	public MySolution() {
		System.out.println("Inside no-arg constructor...");
	}

	public MySolution(int a) {
		System.out.println("Inside single arg constructor...");
	}
	
	{
		min = 10;
		System.out.println("Inside instance initializer....");
	}
	
	public void init() {
	}
	public static void main(String[] args) {
		/*
		 * ArrayList list = new ArrayList(); list.add("heelo"); list.add(2);
		 * 
		 * if(list.get(0) instanceof String) System.out.println("String");
		 * 
		 * if(list.get(1) instanceof Integer) System.out.println("Integer");
		 * 
		 * 
		 * int[] arr = new int[10]; for(int num: arr) System.out.print(num);
		 */
		
	//#System.out.println(5 & 0x55555555);
		
		//System.out.println(2 & 1);
		
		/*	
		 * int[] arr = { 1,2,3,4,5 };
		 * 
		 * System.out.println(Arrays.binarySearch(arr, 7));
		 */
		
		
		 MySolution instance = new MySolution(4); 
		
		 
		 int count = 0;
		 
		 final int caseconst1 = 1;
		 switch(count) {
		 	case caseconst1: 
		 		System.out.println("Count value is zero");
		 		break;
			default:
				System.out.println("Default case...");
		 }
		
		 int arr[] = {1,2};
		 
		 //instance.print(arr);
		
	}
	
	public void print(Integer[] arr)
	{
		
	}
}
