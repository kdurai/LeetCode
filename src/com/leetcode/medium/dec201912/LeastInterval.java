package com.leetcode.medium.dec201912;

/*
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where
 *  different letters represent different tasks. Tasks could be done without original order. Each 
 *  task could be done in one interval. For each interval, CPU could finish one task or just be
 *   idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must
 be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

 */

public class LeastInterval {

	public static void main(String[] args) {

		char[] tasks = { 'A','A','A','B','B','B'};
		System.out.println(leastInterval(tasks, 2));
	}

	public static int leastInterval(char[] tasks, int n) {

		int[] counter = new int[26];
		int max = 0;
		int maxCount = 0;
		for(char task : tasks) {
			counter[task - 'A']++;
			
			if(max == counter[task- 'A'])
				maxCount++;
			else if(max < counter[task - 'A']) {
				max = counter[task - 'A'];
				maxCount = 1;
			}
		}
		
		int partCount = max - 1;
		int partLength = n - (maxCount - 1);
		int emptySlots = partLength * partCount;
		int availableTasks = tasks.length - max * maxCount;
		int idles = Math.max(0, emptySlots - availableTasks);
		
		return tasks.length + idles;
		
    }
}
