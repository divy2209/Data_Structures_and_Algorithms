package StacksAndQueuesQuestions;

import java.util.Stack;

// https://www.youtube.com/watch?v=Lc8LT_84ZwA
// https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/

public class Min_stack {
	// Space O(1) approach
	// topval = 2*x-min;
	// topval = 2*currmin-prevmin;
	// prevmin = 2*currmin-topval;
	Stack<Integer> num = new Stack<Integer>();
	int min;
	Min_stack(){
		while(!num.isEmpty()) num.pop();
	}
	void push(int x) {
		if(num.isEmpty()) {
			min = x;
			num.push(x);
			return;
		}
		if(x<min) {
			num.push(2*x-min);
			min = x;
		} else num.push(x);
	}
	void pop() {
		if(num.isEmpty()) return;
		if(num.peek()<min) {
			int prevmin = 2*min-num.peek();
			min = prevmin;
			num.pop();
		} else num.pop();
	}
	int top() {
		if(num.isEmpty()) return -1;
		if(num.peek()<min) return min;
		else return num.peek();
	}
	int getMin() {
		if(num.isEmpty()) return -1;
		return min;
	}
}

// https://discuss.interviewbit.com/t/using-two-stacks-c-solution/27970
/*public class Min_stack {
	// Space O(n) approach
	Stack<Integer> num = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	Min_stack(){
		while(!num.isEmpty()) num.pop();
		while(!min.isEmpty()) min.pop();
	}
	void push(int x) {
		num.push(x);
		//if(min.isEmpty() || x<min.peek()) min.push(x);
		int temp = x;
		if(!min.isEmpty() && min.peek()<x) temp = min.peek();
		min.push(temp);
	}
	void pop() {
		//if(num.isEmpty()) return;
		//if(num.peek()==min.peek()) min.pop();
		//num.pop();
		if(!num.isEmpty()) {
			num.pop();
			min.pop();
		}
	}
	int top() {
		if(num.isEmpty()) return -1;
		return num.peek();
	}
	int getMin() {
		if(min.isEmpty()) return -1;
		return min.peek();
	}
}*/
