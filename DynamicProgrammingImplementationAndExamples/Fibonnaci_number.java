package DynamicProgrammingImplementationAndExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Fibonnaci_number {
	static ArrayList<Integer> memo = new ArrayList<>(Collections.nCopies(100, 0));
	static int fibTopToBottom(int n) {
		// Top to Bottom approach => Memoization
		// O(n) space and time complexity
		if(n<=1) return n;
		if(memo.get(n)!=0) return memo.get(n);
		memo.set(n, fibTopToBottom(n-1)+fibTopToBottom(n-2));
		return memo.get(n);
	}
	static int fibBottomToTop(int n) {
		// Bottom to Top approach => Tabulation
		// O(n) space and time complexity
		if(n<=1) return n;
		ArrayList<Integer> dp = new ArrayList<>();
		dp.add(0);
		dp.add(1);
		for(int i = 2; i<=n; i++) {
			dp.add(dp.get(i-1)+dp.get(i-2));
		}
		return dp.get(n);
	}
	static int fibBottomToTopEfficient(int n) {
		// Bottom to Top approach => Tabulation
		// O(1) space complexity & O(n) time complexity
		if(n<=1) return n;
		int s1 = 0;
		int s2 = 1;
		for(int i = 2; i<=n; i++) {
			int temp = s1+s2;
			s1=s2;
			s2=temp;
		}
		return s2;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(fibTopToBottom(n));
		System.out.println(fibBottomToTop(n));
		System.out.println(fibBottomToTopEfficient(n));
	}
}
