package DynamicProgrammingImplementationAndExamples;

import java.util.Scanner;

// https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29
public class Longest_repeating_subsequence {
	static int longestRepeatingSubsequence(String str) {
		int n = str.length();
		int[][] dp = new int[n+1][n+1];
		for(int k = 0; k<=n; k++) {
			dp[k][0] = 0;
			dp[0][k] = 0;
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(str.charAt(i-1)==str.charAt(j-1) && i!=j) dp[i][j] = 1+dp[i-1][j-1];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[n][n];
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(longestRepeatingSubsequence(str));
	}
}
