package ArrayQuestions;

import java.util.Scanner;

// A robot is placed in a array at 0,0 and have to move at the end(final size) of the array.
// Robot can only move in right or down direction, how many possible moves.
public class T_line_robot {
	static int total_T_LineMoves(int x, int y) {
		int sum = x+y;
		int steps = factorial(sum)/factorial(x)/factorial(y);
		return steps;
	}
	static int factorial(int num) {
		int fact = 1;
		for(int i=2; i<=num; i++) {
			fact = fact*i;
		}
		return fact;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Size of the array, m(rows)*n(columns)");
		int x = scan.nextInt() - 1;
		int y = scan.nextInt() - 1;
		scan.close();
		int steps = total_T_LineMoves(x, y);
		System.out.println(steps);
	}

}
