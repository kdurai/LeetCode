package com.leetcode.datastructers;

import java.util.LinkedList;

public class MyGraph {
	
	static class Graph {
		
		int V;
		LinkedList<Integer> adjListArray[];
		
		Graph(int V) {
			this.V = V;
			
			adjListArray = new LinkedList[this.V];
			
			for(int i = 0; i < V; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	static void addEdge(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}

	static void printGraph(Graph graph) {
		for(int i = 0; i < graph.V; i++) {
			System.out.println("Adjacency List of Vertex: " + i);
			System.out.print("head");
			
			for(Integer data: graph.adjListArray[i])
			{
				System.out.print(" --> " + data);
			}
			System.out.println();
		}
	}
	
	void BFS(int s) {
		
	}
	
	public static void main(String[] args) {
		
		int V = 5;
		
		Graph graph = new Graph(V);
		
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);

		printGraph(graph);
	}

}
