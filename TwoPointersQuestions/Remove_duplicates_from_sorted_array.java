package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Remove_duplicates_from_sorted_array {
	static int removeDuplicates(ArrayList<Integer> a) {
		if(a.size()==0) return 0;
		int i = 0, j = 0;
		while(j<a.size()) {
			int num = a.get(j);
			while(j<a.size() && a.get(j)==num) j++;
			a.set(i, num);
			i++;
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
		int n = removeDuplicates(a);
		for(int i = 0; i<n; i++) {
			System.out.print(a.get(i) + " ");
		}
	}
}
