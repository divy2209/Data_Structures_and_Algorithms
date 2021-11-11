package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=n-JNgynPi6Q
public class _3_sum {
	static Scanner scan = new Scanner(System.in);
	static int closestSum(ArrayList<Integer> arr, int b) {
		int n = arr.size();
		long ans = Integer.MAX_VALUE;
		Collections.sort(arr);
		for(int i = 0; i<n; i++) {
			int j = i+1, k = n-1;
			while(j<k) {
				long temp = arr.get(i) + arr.get(j) + arr.get(k);
				if(temp==b) return b;
				else if(Math.abs(ans-b)>Math.abs(temp-b)) ans = temp;
				
				if(temp>b) k--;
				else j++;
			}
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
		System.out.println(closestSum(input(), scan.nextInt()));
		scan.close();
	}
}
