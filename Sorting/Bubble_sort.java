package Sorting;

import java.util.Scanner;

public class Bubble_sort {
	static void bubble_sort(int[] arr) {
		int l = arr.length;
		Boolean notSorted = true;
		while(notSorted) {
			notSorted = false;
			for(int i = 0; i<l-1; i++) {
				if(arr[i]>arr[i+1]) {
					swap(arr, i, i+1);
					notSorted = true;
				}
			}
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
		bubble_sort(arr);
		printArray(arr);
	}
}