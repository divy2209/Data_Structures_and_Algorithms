package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// i will increase if the difference is more and j will increase if the difference if less
// https://www.youtube.com/watch?v=XGrXiVi7Ces
public class Pair_with_given_difference {
	static Scanner scan = new Scanner(System.in);
	static int differenceExists(ArrayList<Integer> arr, int a) {
		int n = arr.size();
		if(n==1) return 0;
		int i = 0, j = 1;
		Collections.sort(arr);
		while(i<n&&j<n) {
			int t = arr.get(j)-arr.get(i);
			if(t==a && i!=j) return 1;
			else if(t<a) j++;
			else i++;
		}
		return 0;
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
		System.out.println(differenceExists(input(), scan.nextInt()));
		scan.close();
	}
}
