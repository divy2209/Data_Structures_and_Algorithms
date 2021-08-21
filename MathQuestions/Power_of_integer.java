package MathQuestions;

import java.util.Scanner;

public class Power_of_integer {
	static boolean existsPowerOfInteger(int A) {
		for(int i = 1; i<=Math.sqrt(A); i++) {
			int p = (int)(Math.log(A)/Math.log(i));
			if(Math.pow(i,  p)==A) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		System.out.println(existsPowerOfInteger(A));
	}

}
