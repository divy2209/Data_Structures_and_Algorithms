package StringsQuestions;

import java.util.Scanner;

public class Convert_to_palindrome {
	static boolean isPalindrome(String A, int i, int j) {
		while(i<j) {
			if(A.charAt(i)==A.charAt(j)) {
				i++;
				j--;
			} else return false;
		}
		return true;
	}
	
	static int convertPalindrome(String A) {
		int n = A.length();
		int i = 0, j = n-1;
		while(i<j) {
			if(A.charAt(i)==A.charAt(j)) {
				i++;
				j--;
			} else {
				if(isPalindrome(A, i+1, j)) return 1;
				if(isPalindrome(A, i, j-1)) return 1;
				return 0;
			}
		}
		if(n%2!=0) return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(convertPalindrome(A));
	}
}
