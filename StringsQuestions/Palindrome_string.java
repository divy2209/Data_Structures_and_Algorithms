package StringsQuestions;

import java.util.Scanner;

public class Palindrome_string {
	static int palindromeCheck(String A) {
		int l = A.length();
		String str = "az09";
		int i = 0, j = l-1;
		boolean flag = false;
		A = A.toLowerCase();
		while(i<=j) {
			flag = false;
			if((A.charAt(i)>=str.charAt(0) && A.charAt(i)<=str.charAt(1)) || (A.charAt(i)>=str.charAt(2) && A.charAt(i)<=str.charAt(3))) {
				if((A.charAt(i)>=str.charAt(0) && A.charAt(i)<=str.charAt(1)) || (A.charAt(i)>=str.charAt(2) && A.charAt(i)<=str.charAt(3))) {
					if(A.charAt(i)!=A.charAt(j)) break;
					i++;
					j--;
				} else j--;
			} else i++;
			flag = true;
		}
		if(flag) return 1;
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(palindromeCheck(A));
	}

}
