package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Scanner;

public class Magician_and_chocolates {
	static Scanner scan = new Scanner(System.in);
	static int maximumChocolates(ArrayList<Integer> arr, int a) {
		int n = arr.size();
		long mod = 1000000007;
		long ans = 0;
		for(int i = n/2-1; i>=0; i--) heapify(arr, n, i);
		for(int i = 1; i<=a; i++) {
			ans+=arr.get(0);
			arr.set(0, arr.get(0)/2);
			heapify(arr, n, 0);
			ans%=mod;
		}
		return (int)ans;
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
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		int a = scan.nextInt();
		ArrayList<Integer> arr = input();
		scan.close();
		System.out.println(maximumChocolates(arr, a));
	}
}
