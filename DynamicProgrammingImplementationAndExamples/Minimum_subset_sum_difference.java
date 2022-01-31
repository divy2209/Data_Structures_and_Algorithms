package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13
public class Minimum_subset_sum_difference {
	static int minimumSubsetSumDiff(ArrayList<Integer> arr) {
		int n = arr.size();
		int sum = 0;
		for(int i = 0; i<n; i++) sum+=arr.get(i);
		int s=sum/2;
		boolean[][] dp = new boolean[n+1][s+1];
		for(int i = 0; i<=n; i++) dp[i][0] = true;
		for(int j = 1; j<=s; j++) dp[0][j] = false;
		int ans = sum;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=s; j++) {
				if(arr.get(i-1)<=j) dp[i][j] = dp[i-1][j-arr.get(i-1)] || dp[i-1][j];
				else dp[i][j] = dp[i-1][j];
				
				if(i==n && dp[i][j]) ans = Math.abs(sum-2*j);
			}
		}
		return ans;
	}
	static ArrayList<Integer> input() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(minimumSubsetSumDiff(input()));
	}
}
