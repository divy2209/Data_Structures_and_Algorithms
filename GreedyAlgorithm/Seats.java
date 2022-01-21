package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=SK2ypa7poKg
public class Seats {
	static int seats(String str) {
		int l = str.length();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i<l; i++) {
			if(str.charAt(i)=='x') arr.add(i);
		}
		int n = arr.size();
		if(n==0 || n==l) return 0;
		int hops = 0;
		int mod = 10000003;
		int mid = n/2;
		int cp = arr.get(mid);
		for(int i = 0; i<n; i++) {
			int start = arr.get(i);
			int end = cp-mid+i;
			hops+=Math.abs(start-end);
			hops%=mod;
		}
		return hops;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(seats(str));
	}
}
