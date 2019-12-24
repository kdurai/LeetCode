package com.leetcode.contest.nov201924;

/*
 * 
 * Minimum Time Visiting All Points
On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the 
minimum time in seconds to visit all points.

You can move according to the next rules:

In one second always you can either move vertically, horizontally by one unit or diagonally (it means to 
move one unit vertically and one unit horizontally in one second).
You have to visit the points in the same order as they appear in the array.

*/
public class MinTimeToVisitAllPoints {

	public static void main(String[] args) {

		int[][] points1 = { { 1, 1 }, { 3, 4 }, { -1, 0 } };

		System.out.println(minTimeToVisitAllPoints(points1));

		int[][] points2 = { { 3, 2 }, { -2, 2 } };

		System.out.println(minTimeToVisitAllPoints(points2));

	}

	private static int minTimeToVisitAllPoints(int[][] points) {

		int result = 0;

		for (int i = 0; i < points.length-1; i++) {
			int dx = points[i][0] - points[i + 1][0];
			dx = dx < 0 ? -dx : dx;

			int dy = points[i][1] - points[i + 1][1];
			dy = dy < 0 ? -dy : dy;

			result += (dx > dy ? dx : dy);
		}

		return result;
	}
}
