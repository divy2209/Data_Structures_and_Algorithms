package StacksAndQueuesImplementationAndExamples;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/how-to-implement-stack-in-java-using-array-and-generics/
public class Stack<T> {
	int size;
	ArrayList<T> arr;
	int top = -1;
	Stack(int size){
		this.size = size;
		this.arr = new ArrayList<T>(size);
	}
	void push(T x) {
		if(top==size-1) {
			System.out.println("Stack Overflow");
		} else {
			top++;
			if(arr.size()>top) arr.set(top, x);
			else arr.add(x);
		}
	}
	T pop() {
		if(top==-1) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			return arr.get(top--);
		}
	}
	T peek() {
		return arr.get(top);
	}
	boolean isEmpty() {
		return top==-1;
	}
	int size() {
		return top+1;
	}
}
