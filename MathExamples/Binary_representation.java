package MathExamples;

import java.util.Scanner;

// Saving the remainder at the initial
public class Binary_representation {
	static String binaryRepresentation(int A) {
		if(A==0) return "0";
		String ans = "";
		while(A>0) {
			int temp = A%2;
			ans = Integer.toString(temp) + ans;
			A = A/2;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		String res = binaryRepresentation(A);
		System.out.println(res);
	}

}
