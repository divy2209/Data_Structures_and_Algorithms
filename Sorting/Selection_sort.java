package Sorting;

import java.util.Scanner;

public class Selection_sort{
	static void selection_sort(int[] arr) {
		int l = arr.length;
		for(int i = 0; i<l; i++) {
			int minIndex = i;
			for(int j = i+1; j<l; j++) {
				if(arr[minIndex]>arr[j]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}
	
	static void swap(int[] arr, int x, int y) {
		int a = arr[y];
		arr[y] = arr[x];
		arr[x] = a;
	}
	
	static int[] InputArray() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		return arr;
	}
	
	static void printArray(int[] arr) {
		for(int e = 0; e<arr.length; e++) {
			System.out.print(arr[e]);
			System.out.print(' ');
		}
	}
	
	public static void main(String[] args) {
		int[] arr = InputArray();
		selection_sort(arr);
		printArray(arr);
	}
}