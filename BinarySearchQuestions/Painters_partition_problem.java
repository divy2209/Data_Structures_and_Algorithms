package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Painters_partition_problem {
	static Scanner scan = new Scanner(System.in);
	static int minimumTimeToPaint(ArrayList<Integer> A, int B, int C) {
		int n = A.size();
		long mod = 10000003;
		long sum = 0;
		long low = Integer.MIN_VALUE;
		
		for(int i = 0; i<n; i++) {
			low = Math.max(low, (long)A.get(i));
			sum+=(long)A.get(i);
		}
		
		if(n<=B) return (int)(((low%mod)*C)%mod);
		
		long high = sum;
		long ans = 0;
		
		while(low<=high) {
			long mid = low+(high-low)/2;
			long boardUnits = 0;
			int painters = 1;
			for(int i = 0; i<n; i++) {
				boardUnits+=(long)A.get(i);
				if(boardUnits>mid) {
					boardUnits = (long)A.get(i);
					painters++;
				}
			}
			if(painters<=B) {
				ans = mid;
				high = mid-1;
			} else low = mid+1;
		}
		return (int)(((ans%mod)*C)%mod);
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
		int B = scan.nextInt();
		int C = scan.nextInt();
		ArrayList<Integer> A = input();
		scan.close();
		System.out.println(minimumTimeToPaint(A, B, C));
	}
}
