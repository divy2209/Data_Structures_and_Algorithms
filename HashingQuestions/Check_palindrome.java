package HashingQuestions;

import java.util.HashMap;
import java.util.Scanner;

// https://www.interviewbit.com/discussion/p/java-solution-o-n-o-n/60483/
public class Check_palindrome {
	static int checkPalindrome(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(map.containsKey(c)) map.put(c, map.get(c)+1);
			else map.put(c, 1);
		}
		int flag = 0;
		for(Integer val : map.values()) {
			if(val%2==1 /*(val&1)==1*/) flag++;
		}
		return flag<2?1:0;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(checkPalindrome(str));
	}
}
