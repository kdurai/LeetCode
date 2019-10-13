package com.leetcode.algorithms;

import java.util.Arrays;

/*
 * This is unstable and in-place algorithm
 * Best & Worst Case Time Complexity - O(n2)
 * Auxillary Space = O(1)
 */

public class SelectionSort {

	public static void main(String[] args) {

		int arr[] = {3,8,5,4,1,9,-2};
		
		selectionSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr) {
	
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[j] < arr[min]) 
					min = j;
			}
			
			swap(arr, i, min);
		}
	}

	private static void swap(int[] arr, int i, int min) {
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
	}

}
