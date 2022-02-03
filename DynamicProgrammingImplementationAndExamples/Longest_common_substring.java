package DynamicProgrammingImplementationAndExamples;

import java.util.Scanner;

// https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23
public class Longest_common_substring {
	static int longestCommonSubstring(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 0;
		for(int j = 1; j<=m; j++) dp[0][j] = 0;
		
		int max = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
					max = Math.max(max, dp[i][j]);
				}
				else dp[i][j] = 0;
			}
		}
		
		/*int max = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}*/
		
		return max;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		scan.close();
		System.out.println(longestCommonSubstring(str1, str2));
	}
}
