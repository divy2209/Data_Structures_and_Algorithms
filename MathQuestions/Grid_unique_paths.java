package MathQuestions;

import java.util.Scanner;

// https://www.youtube.com/watch?v=t_f0nwwdg5o
// T-line robot in array questions
public class Grid_unique_paths {
	static int steps(int a, int b) {
		int sum = a+b-2;
		int k = Math.min(a-1, b-1);
		int steps = 1;
		for(int i = 0; i<k; i++) {
			steps = steps*(sum-i)/(i+1);
		}
		return steps;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		System.out.println(steps(a, b));
	}

}
