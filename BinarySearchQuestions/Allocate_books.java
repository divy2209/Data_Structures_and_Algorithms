package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// This can be solved two ways, either by counting the students to distribute all the books or by checking the total sum of the pages in the given number of students
public class Allocate_books {
	static Scanner scan = new Scanner(System.in);
	static int allocateBooksSumCheck(ArrayList<Integer> A, int B) {
		int n = A.size();
		if(n<B) return -1;
		long sum = 0;
		long low = Integer.MIN_VALUE;
		
		for(int i = 0; i<n; i++) {
			low = Math.max(low, (long)A.get(i));
			sum+=(long)A.get(i);
		}
		
		if(n==B) return (int)low;
		long high = sum;
		long ans = -1;
		
		while(low<=high) {
			long mid = low+(high-low)/2;
			int i = 0;
			long temp = sum;
			for(int j = 0; j<B; j++) {
				long pages = 0;
				while(i<n) {
					long t = pages+(long)A.get(i);
					if(t<=mid) pages = t;
					else break;
					i++;
				}
				temp-=pages;
			}
			if(temp==0) {
				ans = mid;
				high = mid-1;
			} else low = mid+1;
		}
		return (int)ans;
	}
	
	static int allocateBooksStudentsCheck(ArrayList<Integer> A, int B) {
		int n = A.size();
		if(n<B) return -1;
		long low = Integer.MIN_VALUE;
		long sum = 0;
		
		for(int i = 0; i<n; i++) {
			low = Math.max(low, (long)A.get(i));
			sum+=(long)A.get(i);
		}
		
		if(n==B) return (int)low;
		long high = sum;
		long ans = -1;
		
		while(low<=high) {
			long mid = low+(high-low)/2;
			long pages = 0;
			int students = 1;
			for(int i = 0; i<n; i++) {
				pages+=(long)A.get(i);
				if(pages>mid) {
					pages = A.get(i);
					students++;
				}
			}
			if(students<=B) {
				ans = mid;
				high = mid-1;
			} else low = mid+1;
		}
		return (int)ans;
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
		System.out.println(allocateBooksStudentsCheck(A, B));
	}
}
