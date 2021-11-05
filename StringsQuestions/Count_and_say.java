package StringsQuestions;

import java.util.Scanner;

public class Count_and_say {
	static String countSayNum(int A) {
		String ans = "1";
		if(A==1) return ans;
		for(int i = 2; i<=A; i++) {
			String temp = "";
			int l = ans.length();
			int count = 0;
			int j = 0;
			char p = ans.charAt(0);
			while(j<l) {
				if(ans.charAt(j)==p) count++;
				else {
					temp = temp + Integer.toString(count) + Character.toString(p);
					p = ans.charAt(j);
					count = 1;
				}
				if(j==l-1) temp = temp + Integer.toString(count) + Character.toString(p);
				j++;
			}
			ans = temp;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		System.out.println(countSayNum(A));
	}
}
