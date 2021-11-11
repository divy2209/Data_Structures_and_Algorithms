package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Remove_duplicates_from_sorted_array_II {
	static int removeDuplicatesTwoAbove(ArrayList<Integer> a) {
		int i = 0, j = 0;
		while(j<a.size()) {
			int num = a.get(j);
			boolean two = false;
			j++;
			while(j<a.size() && num==a.get(j)) {
				j++;
				two = true;
			}
			a.set(i, num);
			i++;
			if(two) {
				a.set(i, num);
				i++;
			}
		}
		return i;
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
		int n = removeDuplicatesTwoAbove(a);
		for(int i = 0; i<n; i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println(a);
	}
}
