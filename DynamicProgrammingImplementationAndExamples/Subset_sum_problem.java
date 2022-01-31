package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7
public class Subset_sum_problem {
	static Scanner scan = new Scanner(System.in);
	static int subsetSum(ArrayList<Integer> arr, int t) {
		int n = arr.size();
		boolean[][] dp = new boolean[n+1][t+1];
		for(int i = 0; i<=n; i++) dp[i][0] = true;
		for(int j = 1; j<=t; j++) dp[0][j] = false;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(arr.get(i-1)<=j) dp[i][j] = dp[i-1][j-arr.get(i-1)] || dp[i-1][j];
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][t] ? 1 : 0;
		
	}
	static ArrayList<Integer> input() {
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int target = scan.nextInt();
		scan.close();
		System.out.println(subsetSum(arr, target));
	}
}
