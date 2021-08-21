package MathQuestions;

import java.util.Scanner;

//https://www.youtube.com/watch?v=tSf-0uYHIDA
public class Greatest_common_divisor {
	static int gcd(int a, int b) {
		int m = Math.max(a,  b);
		int n = Math.min(a,  b);
		while(n!=0) {
			int r = m%n;
			m = n;
			n = r;
		}
		return m;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		System.out.println(gcd(a, b));
	}

}
