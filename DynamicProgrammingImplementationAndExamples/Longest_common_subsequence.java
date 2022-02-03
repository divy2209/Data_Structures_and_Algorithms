package DynamicProgrammingImplementationAndExamples;

import java.util.Arrays;
import java.util.Scanner;

// subsequence and substring is different, substring is continuous and subsequence is discontinuous
// str1=abcdgh
// str2=abedfhr
// subsequence=abdh
// substring=ab
public class Longest_common_subsequence {
	static int[][] memo;
	static int longestCommonSubsequence(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		//return recursionLCS(str1, str2, n, m);
		//return memoizationLCS(str1, str2, n, m);
		return tabulationLCS(str1, str2, n, m);
	}
	static int tabulationLCS(String str1, String str2, int n, int m) {
		// https://www.youtube.com/watch?v=hR3s9rGlMTU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=21
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 0;
		for(int j = 1; j<=m; j++) dp[0][j] = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[n][m];
	}
	static int memoizationLCS(String str1, String str2, int n, int m) {
		// https://www.youtube.com/watch?v=g_hIx4yn9zg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=21
		if(m==0 || n==0) return 0;
		if(memo[n][m]!=-1) return memo[n][m];
		if(str1.charAt(n-1)==str2.charAt(m-1)) return memo[n][m] = 1+memoizationLCS(str1, str2, n-1, m-1);
		return memo[n][m] = Math.max(memoizationLCS(str1, str2, n-1, m), memoizationLCS(str1, str2, n, m-1));
	}
	static int recursionLCS(String str1, String str2, int n, int m) {
		// https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=20
		if(m==0 || n==0) return 0;
		if(str1.charAt(n-1)==str2.charAt(m-1)) return 1+recursionLCS(str1, str2, n-1, m-1);
		return Math.max(recursionLCS(str1, str2, n-1, m), recursionLCS(str1, str2, n, m-1));
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		scan.close();
		memo = new int[str1.length()+1][str2.length()+1];
		Arrays.fill(memo, -1);
		System.out.println(longestCommonSubsequence(str1, str2));
	}
}
