package DynamicProgrammingImplementationAndExamples;

import java.util.Scanner;

// https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28
public class Print_shortest_common_supersequence {
	static String shortestCommonSupersequence(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 0;
		for(int j = 1; j<=m; j++) dp[0][j] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		String ans = "";
		while(dp[n][m]!=0) {
			if(str1.charAt(n-1)==str2.charAt(m-1)) {
				ans = str1.charAt(n-1)+ans;
				m--;
				n--;
			} else {
				if(dp[n-1][m]>dp[n][m-1]) {
					ans = str1.charAt(n-1)+ans;
					n--;
				} else {
					ans = str2.charAt(m-1)+ans;
					m--;
				}
			}
		}
		
		while(n>0) {
			ans = str1.charAt(n-1)+ans;
			n--;
		}
		while(m>0) {
			ans = str2.charAt(m-1)+ans;
			m--;
		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		scan.close();
		System.out.println(shortestCommonSupersequence(str1, str2));
	}
}
