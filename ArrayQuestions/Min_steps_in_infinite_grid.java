package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Min_steps_in_infinite_grid {
	static Scanner scan = new Scanner(System.in);
	static int minSteps(ArrayList<Integer> A, ArrayList<Integer> B) {
		int total_steps = 0, steps = 0, a = A.get(0), b = B.get(0);
		int n = A.size();
		for(int i = 1; i<n; i++) {
			steps = Math.max(Math.abs(a-A.get(i)), Math.abs(b-B.get(i)));
			a = A.get(i);
			b = B.get(i);
			total_steps = total_steps + steps;
		}
		return total_steps;
	}
	static ArrayList<Integer> Input(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Size");
		int n = scan.nextInt();
		
		System.out.println("1st array");
		ArrayList<Integer> A = Input(n);
		
		System.out.println("2nd array");
		ArrayList<Integer> B = Input(n);
		
		int steps = minSteps(A, B);
		System.out.println(steps);
		scan.close();
	}

}
