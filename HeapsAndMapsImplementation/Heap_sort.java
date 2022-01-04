package HeapsAndMapsImplementation;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=HqPJF2L5h9U
// https://www.youtube.com/watch?v=eSwIfy2xJ1g
// https://www.youtube.com/watch?v=W81Qzuz4qH0

// Treemap - https://www.youtube.com/watch?v=ecQJCRBxabY
public class Heap_sort {
	static ArrayList<Integer> heapSort(ArrayList<Integer> arr){
		int n = arr.size();
		for(int i = n/2-1; i>=0; i--) {
			heapify(arr, n, i);
		}
		for(int i = n-1; i>=0; i--) {
			swap(arr, 0, i);
			// heapifying the reduced array, not disturbing the sorted array at the end
			heapify(arr, i, 0);
		}
		return arr;
	}
	static void heapify(ArrayList<Integer> arr, int n, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left<n && arr.get(left)>arr.get(largest)) largest = left;
		if(right<n && arr.get(right)>arr.get(largest)) largest = right;
		if(largest!=i) {
			swap(arr, largest, i);
			heapify(arr, n, largest);
		}
	}
	static void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(heapSort(input()));
	}
}
