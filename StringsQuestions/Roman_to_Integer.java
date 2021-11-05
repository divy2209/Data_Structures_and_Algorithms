package StringsQuestions;

import java.util.Scanner;

public class Roman_to_Integer {
	static int computeInteger(String A) {
		int res = 0;
		int n = A.length();
		
		for(int i = 0; i<n; i++) {
			char c = A.charAt(i);
			if(c=='M') {
				res+=1000;
			} else if(c=='D') {
				res+=500;
			} else if(c=='C') {
				if(i!=n-1 && (A.charAt(i+1)=='M' || A.charAt(i+1)=='D')) res-=100; // In next rotation, either M or D will come and addition will take place
				else res+=100;
			} else if(c=='L') {
				res+=50;
			} else if(c=='X') {
				if(i!=n-1 && (A.charAt(i+1)=='C' || A.charAt(i+1)=='L')) res-=10; // In next rotation, either C or L will come and addition will take place
				else res+=10;
			} else if(c=='V') {
				res+=5;
			} else {
				if(i!=n-1 && (A.charAt(i+1)=='X' || A.charAt(i+1)=='V')) res-=1; // In next rotation, either X or V will come and addition will take place
				else res+=1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(computeInteger(A));
	}
}
