package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Majority_element {
	static int majorityElement(ArrayList<Integer> arr) {
		Collections.sort(arr);
		int n = arr.size();
		int k = n/2;
		int count = 0;
		int prev = arr.get(0);
		for(int i = 0; i<n; i++) {
			if(prev==arr.get(i)) count++;
			else {
				prev = arr.get(i);
				count = 1;
			}
			if(count>=k) return prev;
		}
		return -1;
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println();
	}
}
