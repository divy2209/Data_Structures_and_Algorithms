package StacksAndQueuesImplementationAndExamples;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/how-to-implement-queue-in-java-using-array-and-generics/
public class Queue<T> {
	int front = -1, rear = -1;
	ArrayList<T> arr = new ArrayList<T>();
	T front() {
		if(front == -1) return null;
		return arr.get(front);
	}
	T rear() {
		if(rear == -1) return null;
		return arr.get(rear);
	}
	void enqueue(T x) {
		if(this.empty()) {
			front = 0;
			rear = 0;
			arr.add(x);
		} else {
			rear++;
			if(arr.size()>rear) arr.set(rear, x);
			else arr.add(x);
		}
	}
	void dequeue() {
		if(this.empty()) System.out.println("Queue is empty");
		else if(rear==front) rear = front = -1;
		else front++;
	}
	boolean empty() {
		if(front==-1 && rear==-1) return true;
		return false;
	}
}
