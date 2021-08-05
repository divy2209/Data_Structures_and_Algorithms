package Sorting;

import java.util.Scanner;

public class Quick_sort {
	static void quick_sort(int[] arr, int start, int end) {
		if(start<end) {
			int pivotIndex = pivot_index(arr, start, end);
			quick_sort(arr, start, pivotIndex-1);
			quick_sort(arr, pivotIndex+1, end);
		}
	}
	
	static int pivot_index(int[] arr, int start, int end) {
		int e = arr[end];
		int p = start;
		for(int i = start; i<end; i++) {
			if(arr[i]<=e) {
				swap(arr, i, p);
				p++;
			}
		}
		swap(arr, end, p);
		return p;
	}
	
	static void swap(int[] arr, int original, int pivot) {
		int a = arr[pivot];
		arr[pivot] = arr[original];
		arr[original] = a;
	}
	
	static int[] inputArray() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = inputArray();
		quick_sort(arr, 0, arr.length-1);
		for(int e = 0; e<arr.length; e++) {
			System.out.print(arr[e]);
			System.out.print(' ');
		}
	}
}