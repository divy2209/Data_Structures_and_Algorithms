package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
public class Count_subsets_with_given_difference {
	static Scanner scan = new Scanner(System.in);
	static int countSubsetsWithGivenDifference(ArrayList<Integer> arr, int k) {
		int n = arr.size();
		int sum = 0;
		for(int i = 0; i<n; i++) sum+=arr.get(i);
		// s1-s2=diff
		// s1+s2=sum
		// 2*s1=diff+sum
		// s1=(diff+sum)/2
		// 2*s2=sum-diff
		// s2=(sum-diff)/2
		int s = (sum-k)/2;
		int[][] dp = new int[n+1][s+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 1;
		for(int j = 1; j<=s; j++) dp[0][j] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=s; j++) {
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
		int k = scan.nextInt();
		scan.close();
		System.out.println(countSubsetsWithGivenDifference(arr, k));
	}
}
