package BinarySearchImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

public class Rotated_array {
	static int startElement(ArrayList<Integer> a) {
		int n = a.size();
		if(n==1) return a.get(0);
		if(a.get(0)<a.get(n-1)) return a.get(0);
		int low = 0;
		int high = n-1;
		int min = 0;
		int rotations = -1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(a.get(mid-1)>a.get(mid)) {
				min = a.get(mid);
				rotations = mid; //Number of rotations to achieve this configuration
				break;
			} else if(a.get(mid)>a.get(n-1)) low = mid+1;
			else high = mid-1;
		}
		System.out.println("Number of rotations: " + rotations);
		return min;
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> a = input();
		System.out.println(startElement(a));
	}
}
