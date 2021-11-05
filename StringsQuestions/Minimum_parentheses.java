package StringsQuestions;

import java.util.Scanner;

public class Minimum_parentheses {
	static int parenthesesCount(String A) {
		String str = "()";
		int n = A.length();
		int count = 0, fc = 0;
		for(int i = 0; i<n; i++) {
			if(A.charAt(i)==str.charAt(0)) count++;
			else count--;
			if(count<0) {
				fc++;
				count++;
			}
		}
		return count+fc;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(parenthesesCount(A));
	}
}
