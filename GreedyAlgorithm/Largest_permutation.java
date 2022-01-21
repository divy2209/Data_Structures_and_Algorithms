package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.geeksforgeeks.org/largest-permutation-k-swaps/
public class Largest_permutation {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> largestPermutation(ArrayList<Integer> arr, int b){
		int n = arr.size();
		if(b>=n) {
			Collections.sort(arr, Collections.reverseOrder());
			return arr;
		}
		ArrayList<Integer> key = new ArrayList<>(Collections.nCopies(n+1, 0));
		for(int i = 0; i<n; i++) key.set(arr.get(i), i);
		for(int i = 0; i<n && b>0; i++) {
			if(arr.get(i)!=n-i) {
				int j = key.get(arr.get(i));
				int k = key.get(n-i);
				key.set(arr.get(i), k);
				key.set(n-i, j);
				swap(arr, j, k);
				b--;
			}
		}
		return arr;
	}
	static void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(largestPermutation(input(), scan.nextInt()));
		scan.close();
	}
}
