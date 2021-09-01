package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Rotated_sorted_array_search {
	static Scanner scan = new Scanner(System.in);
	static int search(ArrayList<Integer> A, int B) {
		int n = A.size();
		if(n<3) {
			if(n==1) {
				if(A.get(0)==B) return 0;
				else return -1;
			} else {
				if(A.get(0)==B) return 0;
				else if(A.get(1)==B) return 1;
				else return -1;
			}
		}
		
		int low = 0;
		int high = n-1;
		int p = -1;
		
		if(A.get(n-1)<A.get(0)) {
			while(low<=high) {
				int mid = low+(high-low)/2;
				if(mid!=0 && A.get(mid-1)>A.get(mid)) {
					p = mid;
					break;
				} else if(A.get(mid)>A.get(0)) low = mid+1;
				else high = mid-1;
			}
			
			if(A.get(p)>B || A.get(p-1)<B) return -1;
			else if(B>A.get(n-1)) {
				low = 0;
				high = p-1;
			} else {
				low = p;
				high = n-1;
			}
		} else {
			low = 0;
			high = n-1;
		}
		
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(A.get(mid)==B) return mid;
			else if(A.get(mid)>B) high = mid-1;
			else low = mid+1;
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
		System.out.println(search(A, B));
	}

}
