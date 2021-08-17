package MathExamples;

import java.util.Scanner;

public class Check_prime {
	static int checkPrime(int A) {
		if(A==1) return 0;
		for(int i = 2; i<=Math.sqrt(A); i++) {
			if(A%i==0) return 0;
		}
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		int res = checkPrime(A);
		String ans;
		if(res==0) {
			ans = "No";
		} else ans = "Yes";
		System.out.println(ans);
	}

}
