package DynamicProgrammingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class _0_1_knapsack {
	static Scanner scan = new Scanner(System.in);
	static int knapsack(ArrayList<Integer> v, ArrayList<Integer> w, int c) {
		// It's same knapsack problem, just with using only 2 rows
		int n = v.size();
		int[][] dp = new int[2][c+1];
		dp[0][0] = 0;
		dp[1][0] = 0;
		for(int j = 1; j<=c; j++) dp[0][j] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=c; j++) {
				if(w.get(i-1)<=j) dp[i%2][j] = Math.max(v.get(i-1)+dp[(i-1)%2][j-w.get(i-1)], dp[(i-1)%2][j]);
				else dp[i%2][j] = dp[(i-1)%2][j];
			}
		}
		
		return dp[n%2][c];
	}
	static ArrayList<Integer> input(int n) {
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		int n = scan.nextInt();
		ArrayList<Integer> v = input(n);
		ArrayList<Integer> w = input(n);
		int c = scan.nextInt();
		scan.close();
		System.out.println(knapsack(v, w, c));
	}
}
