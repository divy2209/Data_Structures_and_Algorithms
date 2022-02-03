package DynamicProgrammingImplementationAndExamples;

import java.util.Scanner;

// https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
public class Sequence_pattern_matching {
	static boolean sequencePatternMatching(String a, String b) {
		int n = a.length();
		int m = b.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 0;
		for(int j = 1; j<=m; j++) dp[0][j] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		// checking the length is enough
		if(dp[n][m]!=n) return false;
		else return true;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		System.out.println("Is a subsequence of b " + sequencePatternMatching(a, b));
	}
}
