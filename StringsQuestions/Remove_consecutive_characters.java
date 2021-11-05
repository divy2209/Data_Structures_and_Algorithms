package StringsQuestions;

import java.util.Scanner;

public class Remove_consecutive_characters {
	static String remove(String A, int B) {
		int n = A.length();
		if(B>n) return A;
		String ans = "";
		int lt = 1;
		char p = A.charAt(0);
		for(int i = 1; i<n; i++) {
			if(A.charAt(i)==p) lt++;
			else {
				if(lt!=B) {
					for(int j = 0; j<lt; j++) {
						ans+=Character.toString(p);
					}
				}
				lt = 1;
				p = A.charAt(i);
			}
			if(i==n-1) {
				if(lt!=B) {
					for(int j = 0; j<lt; j++) {
						ans+=Character.toString(p);
					}
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		int B = scan.nextInt();
		scan.close();
		System.out.println(remove(A, B));
	}

}
