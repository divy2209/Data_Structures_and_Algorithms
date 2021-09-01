package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Sorted_insert_position {
	static Scanner scan = new Scanner(System.in);
	static int searchPosition(ArrayList<Integer> a, int b) {
		int n = a.size();
		//if(b<=a.get(0)) return 0;
		if(b>a.get(n-1)) return n;
		
		int low = 0;
		int high = n-1;
		int ans = 0;
		
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(a.get(mid)==b) return mid;
			else if(a.get(mid)>b) {
				high = mid-1;
				ans = mid;
			} else low = mid+1;
		}
		return ans;
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
		ArrayList<Integer> a = input();
		int b = scan.nextInt();
		scan.close();
		System.out.println(searchPosition(a, b));
	}
}
