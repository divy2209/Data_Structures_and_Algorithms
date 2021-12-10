package StacksAndQueuesQuestions;

import java.util.*;

// https://www.youtube.com/watch?v=EpLHQI3_vJ4
public class Sliding_window_maximum {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> slidingMaximumUsingDeque(final ArrayList<Integer> arr, int k){
		int n = arr.size();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Deque<Integer> dq = new LinkedList<Integer>();
		for(int i = 0; i<n; i++) {
			if(!dq.isEmpty() && dq.peekFirst()==i-k) dq.pollFirst();
			while(!dq.isEmpty() && arr.get(dq.peekLast())<arr.get(i)) dq.pollLast();
			dq.add(i);
			if(i+1>=k) ans.add(arr.get(dq.peek()));
		}
		return ans;
	}
	static ArrayList<Integer> slidingMaximumUsingArray(final ArrayList<Integer> arr, int k){
		int n = arr.size();
		ArrayList<Integer> left = new ArrayList<Integer>(n);
		ArrayList<Integer> right = new ArrayList<Integer>(Collections.nCopies(n, 0));
		//int count = 0, max = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++) {
			if(i%k==0) left.add(arr.get(i));
			else left.add(Math.max(left.get(i-1), arr.get(i)));
			/*if(count<k) {
				max = Math.max(max, arr.get(i));
				count++;
				left.add(max);
			}
			if(count==k) {
				max = Integer.MIN_VALUE;
				count = 0;
			}*/
		}
		//max = Integer.MIN_VALUE;
		//count = 0;
		for(int i = n-1; i>=0; i--) {
			if((i+1)%k==0 || i==n-1) right.set(i, arr.get(i));
			else right.set(i, Math.max(right.get(i+1), arr.get(i)));
			/*if(count<k) {
				max = Math.max(max, arr.get(i));
				count++;
				right.set(i, max);
			}
			if(count==k) {
				max = Integer.MIN_VALUE;
				count = 0;
			}*/
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		//end condition i+k-1=n-1
		// i=n-k
		for(int i = 0; i<=n-k; i++) {
			ans.add(Math.max(right.get(i), left.get(i+k-1)));
		}
		return ans;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int k = scan.nextInt();
		scan.close();
		System.out.println(slidingMaximumUsingArray(arr, k));
	}
}
