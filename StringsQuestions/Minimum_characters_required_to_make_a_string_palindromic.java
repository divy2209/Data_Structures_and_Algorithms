package StringsQuestions;

import java.util.Scanner;

//https://www.algostreak.com/post/minimum-characters-required-to-make-a-string-palindromic-interviewbit-solution
// https://www.youtube.com/watch?v=V5-7GzOfADQ
// https://www.youtube.com/watch?v=GTJr8OvyEVQ
// KMP String matching algorithm
public class Minimum_characters_required_to_make_a_string_palindromic {
	static int computeLPS(String A) {
		int n = A.length(), j = 0;
		int[] lps = new int[n];
		lps[0] = 0;
		int i = 1;
		while(i<n) {
			if(A.charAt(i)==A.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			} else {
				if(j!=0) {
					j = lps[j-1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return n/2-lps[n-1];
	}
	
	static int minimumFrontInsertion(String A) {
		StringBuilder sb = new StringBuilder(A);
		sb.reverse();
		String rev = sb.toString();
		A+="$" + rev;
		return computeLPS(A);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(minimumFrontInsertion(A));
	}

}
