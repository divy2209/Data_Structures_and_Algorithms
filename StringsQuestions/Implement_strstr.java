package StringsQuestions;

import java.util.Scanner;

public class Implement_strstr {
	static int strstr(final String A, final String B) {
		int n = A.length();
		int m = B.length();
		if(n==0 || m==0 || m>n) return -1;
		if(m==n && A.equals(B)) return 0;
		int ans = -1;
		int j = 0;
		for(int i = 0; i<n && j<m; i++) {
			if(A.charAt(i)==B.charAt(j)) j++;
			else {
				i = i-j;
				j=0;
			}
			if(j==m) {
				ans = i-m+1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		String B = scan.next();
		scan.close();
		System.out.println(strstr(A, B));
	}
}
