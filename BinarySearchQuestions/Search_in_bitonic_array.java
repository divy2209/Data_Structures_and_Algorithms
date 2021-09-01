package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Search_in_bitonic_array {
	static Scanner scan = new Scanner(System.in);
	
	static int numIndex(ArrayList<Integer> A, int B) {
		int n = A.size();
		int start = 0;
		int end = n-1;
		int peakIndex = 0;
		
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(A.get(mid-1)<A.get(mid) && A.get(mid)>A.get(mid+1)) {
				peakIndex = mid;
				break;
			} else if(A.get(mid-1)<A.get(mid)) start = mid+1;
			else end = mid-1;
		}
		
		int num = A.get(peakIndex);
		if(B>num) return -1;
		
		if(B>=A.get(0)) {
			start = 0;
			end = peakIndex-1;
			while(start<=end) {
				int mid = start+(end-start)/2;
				if(A.get(mid)==B) return mid;
				else if(A.get(mid)<B) start = mid+1;
				else end = mid-1;
			}
		}
		
		if(B>=A.get(n-1)) {
			start = peakIndex;
			end = n-1;
			while(start<=end) {
				int mid = start+(end-start)/2;
				if(A.get(mid)==B) return mid;
				else if(A.get(mid)<B) end = mid-1;
				else start = mid+1;
			}
		}
		return -1;
	}
	
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> A = input();
		int B = scan.nextInt();
		scan.close();
		System.out.println(numIndex(A, B));
	}
}
