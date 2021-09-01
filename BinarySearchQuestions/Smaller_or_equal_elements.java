package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Smaller_or_equal_elements {
	static Scanner scan = new Scanner(System.in);
	static int count(ArrayList<Integer> A, int B) {
		int n = A.size();
		//if(A.get(0)>B) return 0;
		//if(A.get(n-1)<B) return n;
		
		int start = 0;
		int end = n-1;
		int index = -1;
		
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(A.get(mid)<=B) {
				index = mid;
				start = mid+1;
			} else end = mid-1;
		}
		return index+1;
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
		System.out.println(count(A, B));
	}

}
