package StacksAndQueuesImplementationAndExamples;

import java.util.Scanner;

public class Generate_all_parenthese {
	static int checkParenthese(String str) {
		int l = str.length();
		if(l%2==1) return 0;
		Stack<String> s = new Stack<String>(l);
		for(int i = 0; i<l; i++) {
			String temp = Character.toString(str.charAt(i));
			if(temp.equals("(") || temp.equals("{") || temp.equals("[")) {
				if(temp.equals("(")) s.push(")");
				else if(temp.equals("{")) s.push("}");
				else if(temp.equals("[")) s.push("]");
			}
			else {
				if(s.size()==0 || !temp.equals(s.peek())) {
					return 0;
				}
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
		System.out.println(checkParenthese(str));
	}
}
