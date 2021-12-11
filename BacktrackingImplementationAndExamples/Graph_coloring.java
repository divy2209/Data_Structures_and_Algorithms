package BacktrackingImplementationAndExamples;

import java.util.Arrays;
import java.util.Scanner;

public class Graph_coloring {
	static int V;
	static int[] color;
	static Scanner scan = new Scanner(System.in);
	static boolean isItSafeToColor(int[][] graph, int v, int c) {
		for(int i = 0; i<V; i++) {
			if(graph[v][i]==1 && color[i]==c) return false;
		}
		return true;
	}
	static boolean graphColorUtil(int[][] graph, int m, int v) {
		if(v==V) return true;
		for(int i = 1; i<=m; i++) {
			if(isItSafeToColor(graph, v, i)) {
				color[v]=i;
				if(graphColorUtil(graph, m, v+1)) return true;
				color[v]=0;
			}
		}
		return false;
	}
	static boolean graphColouring(int[][] graph, int m) {
		Arrays.fill(color, 0);
		if(!graphColorUtil(graph, m, 0)) {
			System.out.println("Colouring not possible");
			return false;
		}
		print();
		return true;
	}
	static void print() {
		for(int i = 0; i<V; i++) {
			System.out.print(color[i] + " ");
		}
		System.out.println();
	}
	static int[][] input(){
		V = scan.nextInt();
		int[][] graph = new int[V][V];
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				graph[i][j] = scan.nextInt();
			}
		}
		return graph;
	}
	public static void main(String[] args) {
		int[][] graph = input();
		// m is called chromatic number
		int m = scan.nextInt();
		color = new int[V];
		System.out.println(graphColouring(graph, m));
	}
}
