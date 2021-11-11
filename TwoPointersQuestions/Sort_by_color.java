package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Sort_by_color {
	static void swap(ArrayList<Integer> a, int x, int y) {
		int t = a.get(x);
		a.set(x, a.get(y));
		a.set(y, t);
	}
	static void sortArrayByColor(ArrayList<Integer> a) {
		int n = a.size();
		int i = 0, j = n-1, k = 0;
		while(k<=j) {
			if(a.get(k)==2) {
				swap(a, j, k);
				j--;
			} else if(a.get(k)==0) {
				// There are only 3 values, so the k is coming from back removing 2's and if we swap with values of i's, only 1 can come to this place, and we'll leave it as it is
				swap(a, i, k);
				i++;
				k++;
			} else k++;
		}
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> a = input();
		sortArrayByColor(a);
		System.out.println(a);
	}
}
