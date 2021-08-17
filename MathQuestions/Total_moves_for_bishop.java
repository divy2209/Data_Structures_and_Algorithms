package MathQuestions;

import java.util.Scanner;

//https://www.youtube.com/watch?v=z3d0nXyrcR4
// Similar to minimum steps in infinite grid
public class Total_moves_for_bishop {
	static int totalMoves(int A, int B) {
		int topleft = Math.min(B-1, A-1);
		int topright = Math.min(8-B, A-1);
		int bottomleft = Math.min(B-1, 8-A);
		int bottomright = Math.min(8-B, 8-A);
		int steps = topleft+topright+bottomleft+bottomright;
		return steps;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		scan.close();
		int moves = totalMoves(A, B);
		System.out.println(moves);
	}

}
