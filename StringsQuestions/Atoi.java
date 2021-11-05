package StringsQuestions;

import java.util.Scanner;

public class Atoi {
	static int atoi(final String A) {
		int n = A.length();
		if(n==0) return 0;
		int i = 0;
		boolean nsign = false;
		
		while(i<n && A.charAt(i)==' ') i++;
		
		if(A.charAt(i)=='-' || A.charAt(i)=='+') {
			if(i+1==n) return 0;
			if(A.charAt(i+1)<'0' || A.charAt(i+1)>'9') return 0;
			if(A.charAt(i)=='-') nsign = true;
			i++;
		}
		
		long x = 0;
		while(i<n && A.charAt(i)>='0' && A.charAt(i)<='9'){
			x = x*10 + (A.charAt(i)-'0');
			if(x>Integer.MAX_VALUE) {
				if(nsign) return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
			i++;
		}
		
		if(nsign) return -(int)x;
		return (int)x;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(atoi(A));
	}
}
