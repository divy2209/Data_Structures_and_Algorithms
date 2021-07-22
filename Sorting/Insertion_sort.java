package Sorting;

import java.util.Scanner;

public class Insertion_sort {
	static void sort(int[] arr) {
		int n = arr.length;
		for(int i = 1; i<n; i++) {
			int value = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>value) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = value;
		}
	}
	
	static void printArray(int[] arr) {
		int n = arr.length;
		for(int a = 0; a<n; a++) {
			System.out.println(arr[a]);
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
		// TODO Auto-generated method stub
		int[] array = inputArray();
		sort(array);
		printArray(array);
	}

}
