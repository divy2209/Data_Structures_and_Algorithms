package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=w4-a0L2b4M0
public class Diffk {
	static Scanner scan = new Scanner(System.in);
	static int isDiffK(ArrayList<Integer> arr, int k) {
		int i = 0, j = 1;
		int n = arr.size();
		while(j<n && i<n) {
			int diff = arr.get(j)-arr.get(i);
			if(i!=j && diff==k) return 1;
			else if(diff>k) i++;
			else j++;
		}
		return 0;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0;i<n; i++) {
			arr.add(scan.nextInt());
		}
		Collections.sort(arr);
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(isDiffK(input(), scan.nextInt()));
		scan.close();
	}
}
