package MathQuestions;

import java.util.Scanner;

public class Trailiing_zeroes_in_factorial {
	static int zeroes(int A) {
		int count = 0;
		while(A>0) {
			count+=A/5;
			A/=5;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		System.out.println(zeroes(A));
	}

}
