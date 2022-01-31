package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
public class Knapsack {
	static Scanner scan = new Scanner(System.in);
	static int[][] memo;
	static int knapsack(ArrayList<Integer> weights, ArrayList<Integer> values, int capacity) {
		//return knapsackRecursion(weights, values, capacity, weights.size()-1);
		//return knapsackMemoization(weights, values, capacity, weights.size()-1);
		return knapsackTabulation(weights, values, capacity);
	}
	static int knapsackRecursion(ArrayList<Integer> weights, ArrayList<Integer> values, int capacity, int n) {
		// https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4
		if(n<0 || capacity==0) return 0;
		
		if(capacity>=weights.get(n)) {
			return Math.max(values.get(n)+knapsackRecursion(weights, values, capacity-weights.get(n), n-1),
					knapsackRecursion(weights, values, capacity, n-1));
		} else return knapsackRecursion(weights, values, capacity, n-1);
	}
	static int knapsackMemoization(ArrayList<Integer> weights, ArrayList<Integer> values, int capacity, int n) {
		// https://www.youtube.com/watch?v=fJbIuhs24zQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5
		if(n<0 || capacity==0) return 0;
		if(memo[n][capacity]!=-1) return memo[n][capacity];
		
		if(capacity>=weights.get(n)) {
			return memo[n][capacity] = Math.max(values.get(n)+knapsackMemoization(weights, values, capacity-weights.get(n), n-1),
					knapsackMemoization(weights, values, capacity, n-1));
		} else return memo[n][capacity] = knapsackMemoization(weights, values, capacity, n-1);
	}
	static int knapsackTabulation(ArrayList<Integer> weights, ArrayList<Integer> values, int capacity) {
		// https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5
		int n = weights.size();
		int[][] dp = new int[n+1][capacity+1];
		for(int i = 0; i<=n; i++) {
			dp[i][0] = 0;
		}
		for(int j = 0; j<=capacity; j++) {
			dp[0][j] = 0;
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=capacity; j++) {
				if(weights.get(i-1)<=j) {
					dp[i][j] = Math.max(values.get(i-1)+dp[i-1][j-weights.get(i-1)], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][capacity];
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> weights = input();
		ArrayList<Integer> values = input();
		int capacity = scan.nextInt();
		memo = new int[weights.size()+1][capacity+1];
		Arrays.fill(memo, -1);
		scan.close();
		System.out.println(knapsack(weights, values, capacity));
	}
}
