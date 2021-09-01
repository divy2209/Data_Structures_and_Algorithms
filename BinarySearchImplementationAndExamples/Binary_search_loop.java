package BinarySearchImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

public class Binary_search_loop {
	static Scanner scan = new Scanner(System.in);
	
	static int binarySearchIndex(ArrayList<Integer> arr, int num) {
		int n = arr.size();
		int low = 0;
		int high = n-1;
		while(high>=low) {
			int mid = low+(high-low)/2;
			if(arr.get(mid)>num) {
				high = mid -1;
			} else if(arr.get(mid)<num) {
				low = mid+1;
			} else return mid;
		}
		return -1;
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
		int num = scan.nextInt();
		scan.close();
		System.out.println(binarySearchIndex(arr, num));
	}
}
