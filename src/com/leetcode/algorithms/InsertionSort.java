package com.leetcode.algorithms;

import java.util.Arrays;

/*
 * This is stable and in-place algorithm
 * Worst Case Time Complexity - O(n2) ( This can happen when items are in reverse sorted order
 * Best Case Time Complexity - O(n)
 * Auxillary Space = O(1)
 */

public class InsertionSort {

	public static void insertionSort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int j = i;
			
			while(j > 0 && arr[j-1] > value) {
				arr[j] = arr[j-1];
				j--;
			}
			
			arr[j] = value;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {3,8,5,4,1,9,-2};
		
		insertionSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}

}
