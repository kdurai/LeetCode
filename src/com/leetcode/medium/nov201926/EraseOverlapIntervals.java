package com.leetcode.medium.nov201926;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the
 *  rest of the intervals non-overlapping.

Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

*/
public class EraseOverlapIntervals {

	public static void main(String[] args) {
		
		int[][] intervals = { {1,3}, {2,6}, {8,10}, {15,18} };
		System.out.println(eraseOverlapIntervals(intervals));
		
		int[][] intervals2 = { {1,4}, {4,5} };
		System.out.println(eraseOverlapIntervals(intervals2));
	}
	
	private static int eraseOverlapIntervals(int[][] intervals) {
		
		if(intervals.length <= 1)
			return 0;
		
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		
		List<int []> result = new ArrayList<>();
		
		int[] newInterval = intervals[0];
		result.add(newInterval);
		int overlap = -1;
		for(int[] interval : intervals)
			if(interval[0] <= newInterval[1])
			{
				if(interval[0] != newInterval[1])
					overlap++;
				newInterval[1] = Math.min(interval[1], newInterval[1]);
			}
			else
			{
				newInterval = interval;
				result.add(newInterval);
			}
		
		
		return overlap;
    }
}
