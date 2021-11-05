package StringsQuestions;

import java.util.Scanner;

// https://discuss.interviewbit.com/t/3-line-solution/61396
public class Vowel_and_consonant_substrings {
	static int count(String A) {
		String vol = "aeiou";
		int l = A.length();
		int count = 0;
		int mod = 1000000007;
		for(int i = 0; i<l; i++) {
			char c = A.charAt(i);
			if(c==vol.charAt(0)||c==vol.charAt(1)||c==vol.charAt(2)||c==vol.charAt(3)||c==vol.charAt(4)) count++;
		}
		return ((count%mod)*((l-count)%mod)%mod);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(count(A));
	}

}
