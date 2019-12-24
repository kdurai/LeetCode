package com.leetcode.medium.dec201923;

/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note:

Assume that the total area is never beyond the maximum possible value of int.

 */
public class ComputeArea {

	public static void main(String[] args) {

	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int x = Math.min(G, C) > Math.max(E, A) ? (Math.min(G, C) - Math.max(E, A)) : 0;
	    int y = Math.min(D, H) > Math.max(B, F) ? (Math.min(D, H) - Math.max(B, F)) : 0;
	    return (D - B) * (C - A) + (G - E) * (H - F) - x * y;
    }
}
