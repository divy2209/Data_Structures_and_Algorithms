package StacksAndQueuesQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=vYchmWHcjeA
public class Largest_rectangle_in_histogram {
	static int largestRectangleInHistogram(ArrayList<Integer> arr) {
		int n = arr.size();
		ArrayList<Integer> left = new ArrayList<Integer>(n);
		ArrayList<Integer> right = new ArrayList<Integer>(Collections.nCopies(n, n));
		Stack<Integer> num = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		for(int i = 0; i<n; i++) {
			int t = arr.get(i);
			while(!num.isEmpty() && t<=num.peek()) {
				num.pop();
				index.pop();
			}
			if(!num.isEmpty()) left.add(index.peek());
			else left.add(-1);
			num.push(t);
			index.push(i);
		}
		while(!num.isEmpty()) {
			num.pop();
			index.pop();
		}
		for(int i = n-1; i>=0; i--) {
			int t = arr.get(i);
			while(!num.isEmpty() && t<=num.peek()) {
				num.pop();
				index.pop();
			}
			if(!num.isEmpty()) right.set(i, index.peek());
			num.push(t);
			index.push(i);
		}
		//System.out.println(left);
		//System.out.println(right);
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++) {
			// right j++
			// left i--
			// number j-i+1
			// if no small in left side i = -1
			// if no small in right side j = n
			//int area = arr.get(i)*((right.get(i)-1)-(left.get(i)+1)+1);
			int area = arr.get(i)*((right.get(i)-1)-(left.get(i)+1)+1);
			ans = Math.max(ans, area);
		}
		return ans;
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
		System.out.println(largestRectangleInHistogram(input()));
	}
}
