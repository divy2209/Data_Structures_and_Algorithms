package ArrayQuestions;

import java.util.Scanner;

//http://www.mathematische-basteleien.de/taxicabgeometry.htm

// A robot is placed in a array at 0,0 and have to move at the end(final size) of the array.
// Robot can only move in right or down direction, how many possible moves.

// https://www.youtube.com/watch?v=t_f0nwwdg5o
// Unique paths-Maths

public class T_line_robot {
	// At each point we have 2 choices, and the number of downs and rights are fixed to reach the final point.
	// Now we just have to just choose number of downs or right, that's all. sumCdown or sumCright, that's what fibonnaci is
	static int total_T_LineMoves(int x, int y) {
		int sum = x+y;
		int k = Math.max(x, y);
		int steps = 1;
		for(int i = 0; i<k; i++) {
			steps = steps*(sum-i)/(i+1);
		}
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
