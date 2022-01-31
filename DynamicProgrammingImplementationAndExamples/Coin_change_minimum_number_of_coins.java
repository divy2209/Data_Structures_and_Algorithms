package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
public class Coin_change_minimum_number_of_coins {
	static Scanner scan = new Scanner(System.in);
	static int minimumNumberOfCoins(ArrayList<Integer> coins, int sum) {
		int n = coins.size();
		int[][] dp = new int[n+1][sum+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 0;
		for(int j = 1; j<=sum; j++) dp[0][j] = Integer.MAX_VALUE-1;
		int c = coins.get(0);
		for(int j = 1; j<=sum; j++) {
			if(j%c==0) dp[1][j] = j/c;
			else dp[1][j] = Integer.MAX_VALUE-1;
		}
		
		for(int i = 2; i<=n; i++) {
			for(int j = 1; j<=sum; j++) {
				if(coins.get(i-1)<=j) dp[i][j] = Math.min(1+dp[i][j-coins.get(i-1)], dp[i-1][j]);
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
		ArrayList<Integer> coins = input();
		int sum = scan.nextInt();
		scan.close();
		System.out.println(minimumNumberOfCoins(coins, sum));
	}
}
