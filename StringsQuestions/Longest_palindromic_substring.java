package StringsQuestions;

import java.util.Scanner;

public class Longest_palindromic_substring {
	static String longestPalindromicSubstring(String A) {
		int start = 0;
		int maxlength = 1;
		int low, high;
		int n = A.length();
		
		for(int i = 1; i<n; i++) {
			// even length substring
			low = i-1;
			high = i;
			while(low>=0 && high<n && A.charAt(low)==A.charAt(high)) {
				--low;
				++high;
			}
			
			low++;
			high--;
			
			if(A.charAt(low)==A.charAt(high) && high-low+1>maxlength) {
				start = low;
				maxlength = high-low+1;
			}
			
			// odd length substring
			low = i-1;
			high = i+1;
			while(low>=0 && high<n && A.charAt(low)==A.charAt(high)) {
				--low;
				++high;
			}
			
			low++;
			high--;
			
			if(A.charAt(low)==A.charAt(high) && high-low+1>maxlength) {
				start = low;
				maxlength = high-low+1;
			}
		}
		return A.substring(start, (start+maxlength-1)+1);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(longestPalindromicSubstring(A));
	}
}
