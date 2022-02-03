package DynamicProgrammingImplementationAndExamples;

import java.util.Scanner;

// https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
public class Minimum_number_of_insertion_deletion_from_a_to_b {
	static String minimumNumberOfInsertionAndDeletionFrom_a_to_b(String a, String b) {
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
		
		int delete = n-dp[n][m];
		int insert = m-dp[n][m];
		
		return Integer.toString(insert)+" "+Integer.toString(delete);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		System.out.println(minimumNumberOfInsertionAndDeletionFrom_a_to_b(a, b));
	}
}
