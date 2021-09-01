package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Search_for_a_range {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> searchRange(ArrayList<Integer> A, int B){
		int n = A.size();
		int low = 0;
		int high = n-1;
		int start = -1;
		int end = -1;
		ArrayList<Integer> ans = new ArrayList<Integer>(2);
		
		while(low<=high) {
			int mid = low+(high-low)/2;
			if((mid==0 || A.get(mid-1)!=B) && A.get(mid)==B) {
				start = mid;
				break;
			} else if(A.get(mid)<B) low = mid+1;
			else high = mid-1;
		}
		
		ans.add(start);
		if(start==-1) {
			ans.add(end);
			return ans;
		}
		
		low = 0;
		high = n-1;
		
		while(low<=high) {
			int mid = low+(high-low)/2;
			if((mid==n-1 || A.get(mid+1)!=B) && A.get(mid)==B) {
				end = mid;
				break;
			} else if(A.get(mid)>B) high = mid-1;
			else low = mid+1;
		}
		
		ans.add(end);
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
		System.out.println(searchRange(A, B));
	}

}
