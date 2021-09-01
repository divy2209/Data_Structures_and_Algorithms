package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=W-UalzYVEiQ
public class Woodcutting_made_easy {
	static Scanner scan = new Scanner(System.in);
	static int optimumHeight(ArrayList<Integer> A, int B) {
		int n = A.size();
		int start = 0;
		int end = 0;
		
		for(int i = 0; i<n; i++) {
			end = Math.max(end, A.get(i));
		}
		
		int ans = 0;
		while(start<=end) {
			int mid = start+(end-start)/2;
			long wood = 0;
			for(int i = 0; i<n; i++) {
				if(A.get(i)-mid>0) wood = wood + (long)(A.get(i)-mid);
			}
			if(wood==(long)B) return mid;
			else if(wood>(long)B) {
				start = mid+1;
				ans = Math.max(ans, mid);
			} else end = mid-1;
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
		ArrayList<Integer> A = input();
		int B = scan.nextInt();
		scan.close();
		System.out.println(optimumHeight(A, B));
	}

}
