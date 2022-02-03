package DynamicProgrammingImplementationAndExamples;

import java.util.Scanner;

// https://www.geeksforgeeks.org/longest-repeated-subsequence/
public class Print_longest_repeating_subsequence {
	static String longestRepeatingSubsequence(String str) {
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
		
		String ans = "";
		int m = n;
		while(n>0&&m>0) {
			if(str.charAt(n-1)==str.charAt(m-1) && n!=m) {
				ans = str.charAt(n-1) + ans;
				m--;
				n--;
			} else {
				if(dp[n-1][m]>dp[n][m-1]) n--;
				else m--;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(longestRepeatingSubsequence(str));
	}
}
