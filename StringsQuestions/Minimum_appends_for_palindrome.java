package StringsQuestions;

import java.util.Scanner;

public class Minimum_appends_for_palindrome {
	static int computeLPS(String B) {
		int n = B.length(), j = 0;
		int[] lps = new int[n];
		lps[0]=0;
		int i = 1;
		while(i<n) {
			if(B.charAt(i)==B.charAt(j)) {
				j++;
				lps[i]=j;
				i++;
			} else {
				if(j!=0) {
					j=lps[j-1];
				} else {
					lps[i]=0;
					i++;
				}
			}
		}
		return n/2-lps[n-1];
	}
	
	static int minAppends(String A) {
		StringBuilder sb = new StringBuilder(A);
		sb.reverse();
		String B = sb.toString() + "$" + A;
		return computeLPS(B);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(minAppends(A));
	}
}
