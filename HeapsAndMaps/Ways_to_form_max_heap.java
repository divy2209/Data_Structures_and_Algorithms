package HeapsAndMaps;

import java.util.Scanner;

// https://tutorialspoint.dev/algorithm/dynamic-programming-algorithms/number-ways-form-heap-n-distinct-integers	
// https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/
public class Ways_to_form_max_heap {
	static long[][] ncr;
	static long[] dp;
	static int[] log2;
	static long mod = 1000000007;
	
	static long choose(int n, int k) {
		if(k>n) return 0;
		if(n<=1) return 1;
		if(k==0) return 1;
		if(ncr[n][k]!=-1) return ncr[n][k];
		long ans = choose(n-1, k-1) + choose(n-1, k);
		ans%=mod;
		ncr[n][k] = ans;
		return ans;
	}
	static int getLeft(int n) {
		if(n==1) return 0;
		
		int h = log2[n];
		int m = (1<<h);
		int p = n-((1<<h)-1);
		if(p>=m/2) return (1<<h)-1;
		else return (1<<h)-1-(m/2-p);
	}
	static long numberOfHeaps(int n) {
		if(n<=1) return 1;
		if(dp[n]!=-1) return dp[n];
		int left = getLeft(n);
		long ans = (choose(n-1,left)*numberOfHeaps(left))%mod*numberOfHeaps(n-left-1);
		ans%=mod;
		dp[n]=ans;
		return ans;
	}
	static int waysToMaxHeap(int n) {
		dp = new long[n+1];
		ncr = new long[n+1][n+1];
		log2 = new int[n+1];
		for(int i = 0; i<=n; i++) {
			dp[i] = -1;
			for(int j = 0; j<=n; j++) {
				ncr[i][j] = -1;
			}
		}
		int currlog2 = -1;
		int currpower = 1;
		for(int i = 0; i<=n; i++) {
			if(currpower==i) {
				currlog2++;
				currpower*=2;
			}
			log2[i] = currlog2;
		}
		return (int)numberOfHeaps(n);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(waysToMaxHeap(n));
	}
	
}
