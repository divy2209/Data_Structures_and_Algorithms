package StringsQuestions;

import java.util.Scanner;

// https://www.youtube.com/watch?v=I80Ovvi_nRU
public class Power_of_2 {
	static int powerCheck(String A) {
		int k = 0;
		int i = 0;
		int len = A.length();
		
		while(i<len) {
			k = k*10 + (A.charAt(i)-'0');
			i++;
		}
		
		if(k==1) return 0;
		if((k&(k-1))!=0) return 0;
		return 1;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(powerCheck(A));
	}
}
