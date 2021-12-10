package StacksAndQueuesQuestions;

import java.util.Scanner;
import java.util.Stack;

public class Balanced_parantheses {
	static int balanced(String str) {
		int l = str.length();
		if(l%2==1) return 0;
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i<l; i++) {
			if(str.charAt(i)=='(') s.push(str.charAt(i));
			else {
				if(s.size()==0) return 0;
				else s.pop();
			}
		}
		if(s.size()!=0) return 0;
		return 1;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(balanced(str));
	}
}
