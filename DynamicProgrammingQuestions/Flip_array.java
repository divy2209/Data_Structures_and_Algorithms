package DynamicProgrammingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://github.com/JayakrishnaThota/InterviewBit/blob/master/Level%207/Dynamic%20Programming/Flip%20Array
public class Flip_array {
	static int minimumSignFlips(ArrayList<Integer> arr) {
		int n = arr.size();
		int sum = 0;
		for(int i = 0; i<n; i++) sum+=arr.get(i);
		int s = sum/2;
		int[][] dp = new int[n+1][s+1];
		for(int i = 0; i<=n; i++) dp[i][0] = 0;
		for(int j = 1; j<=s; j++) dp[0][j] = 1000000;
		
		int index = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=s; j++) {
				dp[i][j] = dp[i-1][j];
				if(arr.get(i-1)<=j) {
					if(dp[i][j]>dp[i-1][j-arr.get(i-1)]+1) dp[i][j] = dp[i-1][j-arr.get(i-1)]+1;
				}
				if(i==n && dp[i][j]!=1000000) index = j;
			}
		}
		
		return dp[n][index];
	}
	static ArrayList<Integer> input() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(minimumSignFlips(input()));
	}
}
