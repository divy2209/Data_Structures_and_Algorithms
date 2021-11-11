package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Merge_two_sorted_lists_II {
	static Scanner scan = new Scanner(System.in);
	static void mergeSortedArrays(ArrayList<Integer> a, ArrayList<Integer> b){
		int i = 0, j = 0;
		while(i<a.size() && j<b.size()) {
			if(a.get(i)<=b.get(j)) {
				i++;
			} else {
				a.add(i, b.get(j));
				i++;
				j++;
			}
		}
		while(j<b.size()) {
			a.add(b.get(j));
			j++;
		}
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
		ArrayList<Integer> b = input();
		scan.close();
		mergeSortedArrays(a, b);
		System.out.println(a);
	}
}
