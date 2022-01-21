package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assign_mice_to_holes {
	static Scanner scan = new Scanner(System.in);
	static int miceAssigning(ArrayList<Integer> a, ArrayList<Integer> b) {
		int n = a.size();
		Collections.sort(a);
		Collections.sort(b);
		int time = 0;
		for(int i = 0; i<n; i++) {
			time  = Math.max(time, Math.abs(a.get(i)-b.get(i)));
		}
		return time;
	}
	static ArrayList<Integer> input(int n){
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n ;i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		int n = scan.nextInt();
		ArrayList<Integer> a = input(n);
		ArrayList<Integer> b = input(n);
		System.out.println(miceAssigning(a, b));
	}
}
