package StacksAndQueuesQuestions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=496MkZvlWac
public class Nearest_smaller_element {
	static ArrayList<Integer> nearestSmallerNumber(ArrayList<Integer> arr){
		int n = arr.size();
		ArrayList<Integer> a = new ArrayList<Integer>(n);
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i<n; i++) {
			int t = arr.get(i);
			while(!s.isEmpty() && t<=s.peek()) s.pop();
			if(!s.isEmpty()) a.add(s.peek());
			else a.add(-1);
			s.push(t);
		}
		return a;
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
		System.out.println(nearestSmallerNumber(input()));
	}
}
