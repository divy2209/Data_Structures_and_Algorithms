package MathQuestions;

import java.util.Scanner;

public class Palindrome_integer {
	static boolean isPalindrome(int n) {
		int rev = 0, temp = n;
		while(temp>0) {
			rev = temp%10 + rev*10;
			temp/=10;
		}
		return rev==n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(isPalindrome(n));
	}

}
