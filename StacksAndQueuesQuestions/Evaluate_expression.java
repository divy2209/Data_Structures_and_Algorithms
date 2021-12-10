package StacksAndQueuesQuestions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=q6tj7yplRck
public class Evaluate_expression {
	static int evaluateExrpession(ArrayList<String> arr) {
		// commented code still needs work
		int n = arr.size();
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i<n; i++) {
			String str = arr.get(i);
			if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				int num2 = s.pop();
				int num1 = s.pop();
				if(str.equals("+")) {
					s.push(num1+num2);
					//s.push(s.pop()+s.pop());
				} else if(str.equals("-")) {
					s.push(num1-num2);
					//s.push((-1)*(s.pop()-s.pop()));
				} else if(str.equals("*")) {
					s.push(num1*num2);
					//s.push(s.pop()*s.pop());
				} else {
					s.push(num1/num2);
					//s.push(1/(s.pop()/s.pop()));
				}
			} else {
				s.push(Integer.parseInt(str));
			}
		}
		return s.peek();
	}
	static ArrayList<String> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<String> arr = new ArrayList<String>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.next());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(evaluateExrpession(input()));
	}
}
