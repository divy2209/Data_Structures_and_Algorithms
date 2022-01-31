package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
public class Target_sum {
	static Scanner scan = new Scanner(System.in);
	static int targetSum(ArrayList<Integer> arr, int t) {
		int n = arr.size();
		int sum = 0;
		for(int i = 0; i<n; i++) sum+=arr.get(i);
		if(sum<Math.abs(t) || (sum+t)%2!=0) return 0;
		int s = (sum-t)/2;
		int[][] dp = new int[n+1][s+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 1;
		for(int j = 1; j<=s; j++) dp[0][j] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<=s; j++) {
				// j starts from 0, because 0s are considered valid in this problem, e.g - nums: [0,0,0,0], target: 0, ans = 16
				if(arr.get(i-1)<=j) dp[i][j] = dp[i-1][j-arr.get(i-1)]+dp[i-1][j];
				else dp[i][j] = dp[i-1][j];
			}
		}
		return dp[n][s];
	}
	static ArrayList<Integer> input() {
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int t = scan.nextInt();
		scan.close();
		System.out.println(targetSum(arr, t));
	}
}
