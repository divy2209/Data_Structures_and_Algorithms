package StringsQuestions;

import java.util.Scanner;

public class Length_of_last_word {
	static int lengthOfLastWord(final String A) {
		String[] s = A.split(" ");
		int len = 0;
		for(int i = s.length-1; i>=0; i--) {
			if(s[i].length()>0) {
				len = s[i].length();
				break;
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(lengthOfLastWord(A));
	}
}
