package StacksAndQueuesQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=qJz9QXrgzYk
public class MAXSPPROD {
	static int maxspprod(ArrayList<Integer> arr) {
		int n = arr.size();
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			int t = arr.get(i);
			while(!s.isEmpty() && t>=s.peek()) {
				s.pop();
				index.pop();
			}
			if(s.isEmpty()) left.add(0);
			else left.add(index.peek());
			s.push(t);
			index.push(i);
		}
		while(!s.isEmpty()) {
			s.pop();
			index.pop();
		}
		ArrayList<Integer> right = new ArrayList<Integer>(Collections.nCopies(n, 0));
		for(int i = n-1; i>=0; i--) {
			int t = arr.get(i);
			while(!s.isEmpty() && t>=s.peek()) {
				s.pop();
				index.pop();
			}
			if(s.isEmpty()) right.set(i, 0);
			else right.set(i, index.peek());
			s.push(t);
			index.push(i);
		}
		//System.out.println(left);
		//System.out.println(right);
		
		long mod = 1000000007;
		long ans = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++) {
			ans = Math.max(ans, (long)left.get(i)*(long)right.get(i));
		}
		return (int)(ans%mod);
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(maxspprod(input()));
	}
}
