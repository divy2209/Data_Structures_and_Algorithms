package StacksAndQueuesQuestions;

import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=h1KVmq2oGhE
public class Simplify_directory_path {
	static String simplfyDirectoryPath(String str) {
		int l = str.length();
		int i = 0;
		Stack<String> s = new Stack<String>();
		while(i<l) {
			if(str.charAt(i)=='/') {
				i++;
				int j = i;
				String temp = "";
				while(i<l && str.charAt(i)!='/') {
					temp+=Character.toString(str.charAt(i));
					i++;
				}
				if(j<i) {
					// substring method takes O(n) time, so combined it with the previous loop only
					//String temp = str.substring(j, i);
					if(temp.equals(".")) continue;
					else if(temp.equals("..")) {
						if(s.size()>0) s.pop();
					}
					else s.push(temp);
				}
			}
		}
		String result = "";
		while(s.size()!=0) result = "/" + s.pop() + result;
		if(result.equals("")) result = "/";
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(simplfyDirectoryPath(str));
	}
}
