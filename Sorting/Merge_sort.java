package Sorting;

import java.util.Scanner;

public class Merge_sort{
	static void merge_sort(int[] arr, int start, int end) {
		if(start != end) {
			int mid = (start+end)/2;
			merge_sort(arr, start, mid);
			merge_sort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	static void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end-start+1];
		int i = start;
		int j = mid+1;
		int k = 0;
		
		while(i<=mid && j<=end) {
			if(arr[i]<=arr[j]) {
				temp[k] = arr[i];
				k++;
				i++;
			} else {
				temp[k] = arr[j];
				k++;
				j++;
			}
		}
		
		while(i<=mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		
		while(j<=end) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		
		for(i = start; i<=end; i++) {
			arr[i] = temp[i-start];
		}
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
		merge_sort(arr, 0, arr.length-1);
		for(int e = 0; e<arr.length; e++) {
			System.out.print(arr[e]);
			System.out.print(' ');
		}
	}
}