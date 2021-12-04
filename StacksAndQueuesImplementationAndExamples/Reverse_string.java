package StacksAndQueuesImplementationAndExamples;

import java.util.Scanner;

public class Reverse_string {
	static String reverseString(String str) {
		int l = str.length();
		Stack<String> s = new Stack<String>(l);
		for(int i = 0; i<l; i++) {
			s.push(Character.toString(str.charAt(i)));
		}
		String result = "";
		while(!s.isEmpty()) {
			result+=s.peek();
			s.pop();
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(reverseString(str));
	}
}
