package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=vcz4-mbBWbc
public class Profit_maximization {
	static Scanner scan = new Scanner(System.in);
	static int profitMaximization(ArrayList<Integer> arr, int b) {
		int n = arr.size();
		for(int i = n/2-1; i>=0; i--) heapify(arr, n, i);
		int ans = 0;
		for(int i = 1; i<=b; i++) {
			ans+=arr.get(0);
			arr.set(0, arr.get(0)-1);
			heapify(arr, n, 0);
		}
		return ans;
	}
	static void heapify(ArrayList<Integer> arr, int n, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left<n && arr.get(left)>arr.get(largest)) largest = left;
		if(right<n && arr.get(right)>arr.get(largest)) largest = right;
		if(largest!=i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
		}
	}
	static void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i,  arr.get(j));
		arr.set(j,  temp);
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int b = scan.nextInt();
		scan.close();
		System.out.println(profitMaximization(arr, b));
	}
}
