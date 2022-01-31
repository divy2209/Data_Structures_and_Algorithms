package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
public class Unbounded_knapsack {
	static Scanner scan = new Scanner(System.in);
	static int unboundedKnapsack(ArrayList<Integer> v, ArrayList<Integer> w, int weight) {
		int n = v.size();
		int[][] dp = new int[n+1][weight+1];
		for(int i = 0; i<=n; i++) {
			for(int j = 0; j<=weight; j++) {
				dp[i][j] = 0;
			}
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=weight; j++) {
				if(w.get(i-1)<=j) dp[i][j] = Math.max(v.get(i-1)+dp[i][j-w.get(i-1)], dp[i-1][j]);
				else dp[i][j] = dp[i-1][j];
			}
		}
		return dp[n][weight];
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
		int weight = scan.nextInt();
		scan.close();
		System.out.println(unboundedKnapsack(v, w, weight));
	}
}
