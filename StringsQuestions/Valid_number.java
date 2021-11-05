package StringsQuestions;

import java.util.Scanner;

public class Valid_number {
	static boolean isValidNumber(String A) {
		A = A.trim();
		int n = A.length();
		boolean eseen = false;
		boolean numseen = false;
		boolean dotseen = false;
		
		for(int i = 0; i<n; i++) {
			char c = A.charAt(i);
			if(Character.isDigit(c)) numseen = true;
			else if(c=='e') {
				if(eseen || !numseen) return false;
				eseen = true;
				numseen = false;
			} else if(c=='.') {
				if(dotseen || eseen) return false;
				dotseen = true;
				numseen = false;
			} else if(c=='-' || c=='+') {
				if(i!=0 && A.charAt(i-1)!='e') return false;
			} else return false;
		}
		return numseen;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(isValidNumber(A));
	}
}
