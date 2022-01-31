package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
public class Count_of_subset_with_a_given_sum {
	static Scanner scan = new Scanner(System.in);
	static int countOfSubsetWithAGivenSum(ArrayList<Integer> arr, int sum) {
		int n = arr.size();
		int[][] dp = new int[n+1][sum+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 1;
		for(int j = 1; j<=sum; j++) dp[0][j] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=sum; j++) {
				if(arr.get(i-1)<=j) dp[i][j] = dp[i-1][j-arr.get(i-1)]+dp[i-1][j];
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][sum];
	}
	static ArrayList<Integer> input() {
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int sum = scan.nextInt();
		scan.close();
		System.out.println(countOfSubsetWithAGivenSum(arr, sum));
	}
}
