package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
public class Equal_sum_partition {
	static int equalSumPartition(ArrayList<Integer> arr) {
		int n = arr.size();
		long sum = 0;
		for(int i = 0; i<n; i++) sum+=(long)arr.get(i);
		if(sum%2==1) return 0;
		sum/=2;
		
		boolean[][] dp = new boolean[n+1][(int)sum+1];
		for(int i = 0; i<=n; i++) dp[i][0] = true;
		for(int j = 1; j<=(int)sum; j++) dp[0][j] = false;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=(int)sum; j++) {
				if(arr.get(i-1)<=j) dp[i][j] = dp[i-1][j-arr.get(i-1)] || dp[i-1][j];
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][(int)sum] ? 1 : 0;
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		System.out.println(equalSumPartition(arr));
	}
}
