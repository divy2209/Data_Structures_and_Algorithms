package DynamicProgrammingQuestions;

import java.util.Scanner;

public class Stairs {
	static int climbStairs(int n) {
		if(n<=2) return n;
		int s1 = 1;
		int s2 = 2;
		for(int i = 2; i<=n; i++) {
			s2=s1+s2;
			s1=s2-s1;
		}
		return s2;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(climbStairs(n));
	}
}
