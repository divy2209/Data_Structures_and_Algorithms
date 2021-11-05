package StringsQuestions;

import java.util.Scanner;

public class Reverse_the_string {
	static String reverseString(String A) {
		String[] s = A.split(" ");
		String str = "";
		for(int i = s.length-1; i>=0; i--) {
			if(s[i].length()>0) str+=s[i]+" ";
		}
		return str.trim();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(reverseString(A));
	}
}
