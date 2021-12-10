package StacksAndQueuesQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=d_NQVc1tBZ0
public class Rain_water_trapped {
	// O(1) space approach to be understood
	static int trappedWaterOn(final ArrayList<Integer> arr) {
		// O(n) approach
 		int n = arr.size();
		ArrayList<Integer> lmx = new ArrayList<Integer>(n);
		ArrayList<Integer> rmx = new ArrayList<Integer>(Collections.nCopies(n, 0));
		lmx.add(arr.get(0));
		rmx.set(n-1, arr.get(n-1));
		for(int i = 1; i<n; i++) {
			lmx.add(Math.max(lmx.get(i-1), arr.get(i)));
		}
		for(int i = n-2; i>=0; i--) {
			rmx.set(i, Math.max(rmx.get(i+1), arr.get(i)));
		}
		int ans = 0;
		for(int i = 0; i<n; i++) {
			int water = Math.min(lmx.get(i), rmx.get(i))-arr.get(i);
			ans+=water!=0 ? water : 0;
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
		System.out.println(trappedWaterOn(input()));
	}
}
