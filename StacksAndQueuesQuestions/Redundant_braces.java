package StacksAndQueuesQuestions;

import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=K6m7ysIgGko
public class Redundant_braces {
	static int checkRedundantBraces(String str) {
		Stack<Character> s = new Stack<Character>();
		int l = str.length();
		//boolean check = false;
		for(int i = 0; i<l; i++) {
			if(str.charAt(i)==')') {
				int count = 0;
				while(s.size()>0 && s.peek()!='(') {
					//if(s.peek()=='+' || s.peek()=='-' || s.peek()=='*' || s.peek()=='/') check = true;
					count++;
					s.pop();
				}
				if(s.size()>0)s.pop();
				//if(!check) return 1;
				//check = false;
				// if the count is more than 1, meaning there are atleast 2 nums and one operator, so braces not redundant
				if(count<=1) return 1;
			} else s.push(str.charAt(i));
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(checkRedundantBraces(str));
	}
}
