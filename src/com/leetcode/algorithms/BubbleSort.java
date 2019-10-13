package com.leetcode.algorithms;

import java.util.Arrays;

public class BubbleSort {

	
	public static void main(String[] args) {
		
		int arr[] = {3,8,5,4,1,9,-2};
		
		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));

		int arr2[] = {-2, 1, 3, 4, 5, 8, 9};
		
		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void bubbleSort(int[] arr) {

		for(int i = 0; i < arr.length - 1; i++) {
			
			boolean swapped = false;
			
			for (int j = 0; j < arr.length - 1 - i; j++)
				if(arr[j] > arr[j+1])
				{
					swap(arr, j, j+1);
					swapped = true;
				}
			
			if(!swapped)
			{
				System.out.println("Not swapped");
				break;
			}
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
