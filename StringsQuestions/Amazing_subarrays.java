package StringsQuestions;

import java.util.Scanner;

// https://www.algostreak.com/post/amazing-subarrays-interviewbit-solution
public class Amazing_subarrays {
	static int amazingSubarrays(String A) {
		int count = 0;
		int mod = 10003;
		int l = A.length();
		String vol = "aeiou";
		A = A.toLowerCase();
		for(int i = 0; i<l; i++) {
			char c = A.charAt(i);
			if(c==vol.charAt(0)||c==vol.charAt(1)||c==vol.charAt(2)||c==vol.charAt(3)||c==vol.charAt(4)) {
				count = count + (l-i);
				count%=mod;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(amazingSubarrays(A));
	}
}
