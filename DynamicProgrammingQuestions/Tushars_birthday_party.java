package DynamicProgrammingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Tushars_birthday_party {
	static Scanner scan = new Scanner(System.in);
	static int optimizedMinimumBirthdayPartyCost(ArrayList<Integer> friends, ArrayList<Integer> dishes, ArrayList<Integer> cost) {
		// This is super optimized
		int n = dishes.size();
		int f = friends.size();
		int ans = 0, max = 0;
		int cap = 0/*1000*/;
		
		// We can go one step up and find the max in friends capacity instead of using value limit 1000
		for(int k = 0; k<f; k++) cap = Math.max(cap, friends.get(k));
		
		int[][] dp = new int[n+1][cap+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 0;
		for(int j = 1; j<=cap; j++) dp[0][j] = 10000000;
		
		for(int k = 0; k<f; k++) {
			int s = friends.get(k);
			if(max>=s) {
				ans+=dp[n][s];
				continue;
			}
			
			for(int i = 1; i<=n; i++) {
				for(int j = max+1; j<=s; j++) {
					if(dishes.get(i-1)<=j) dp[i][j] = Math.min(cost.get(i-1)+dp[i][j-dishes.get(i-1)], dp[i-1][j]);
					else dp[i][j] = dp[i-1][j];
				}
			}
			
			max = Math.max(max, s);
			ans+=dp[n][s];
		}
		
		return ans;
	}
	static int minimumBirthdayPartyCost(ArrayList<Integer> friends, ArrayList<Integer> dishes, ArrayList<Integer> cost) {
		int n = dishes.size();
		int f = friends.size();
		int ans = 0;
		for(int k = 0; k<f; k++) {
			int s = friends.get(k);
			int[][] dp = new int[n+1][s+1];
			for(int i = 0; i<=n; i++) dp[i][0] = 0;
			for(int j = 1; j<=s; j++) dp[0][j] = 10000000;
			
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=s; j++) {
					if(dishes.get(i-1)<=j) dp[i][j] = Math.min(cost.get(i-1)+dp[i][j-dishes.get(i-1)], dp[i-1][j]);
					else dp[i][j] = dp[i-1][j];
				}
			}
			
			ans+=dp[n][s];
		}
		
		return ans;
	}
	static ArrayList<Integer> input() {
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> friends = input();
		ArrayList<Integer> dishes = input();
		ArrayList<Integer> cost = input();
		scan.close();
		System.out.println(minimumBirthdayPartyCost(friends, dishes, cost));
		System.out.println(optimizedMinimumBirthdayPartyCost(friends, dishes, cost));
	}
}
