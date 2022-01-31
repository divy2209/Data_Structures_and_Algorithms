package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
public class Rod_cutting {
	static Scanner scan = new Scanner(System.in);
	static int rodCutting(ArrayList<Integer> l, ArrayList<Integer> p, int len) {
		int n = l.size();
		int[][] dp = new int[n+1][len+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 0;
		for(int j = 1; j<=len; j++) dp[0][j] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=len; j++) {
				if(l.get(i-1)<=j) dp[i][j] = Math.max(p.get(i-1)+dp[i][j-l.get(i-1)], dp[i-1][j]);
				else dp[i][j] = dp[i-1][j];
			}
		}
		return dp[n][len];
	}
	static ArrayList<Integer> input(int n) {
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		int n = scan.nextInt();
		ArrayList<Integer> l = input(n);
		ArrayList<Integer> p = input(n);
		int len = scan.nextInt();
		scan.close();
		System.out.println(rodCutting(l, p, len));
	}
}
