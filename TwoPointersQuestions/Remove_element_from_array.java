package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Remove_element_from_array {
	static Scanner scan = new Scanner(System.in);
	static int removeElement(ArrayList<Integer> a, int b) {
		int i = 0, j = 0;
		while(j<a.size()) {
			if(a.get(j)!=b) {
				a.set(i, a.get(j));
				i++;
				j++;
			} else j++;
		}
		return i;
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
		int b = scan.nextInt();
		scan.close();
		int n = removeElement(a, b);
		for(int i = 0; i<n; i++) {
			System.out.print(a.get(i) + " ");
		}
	}
}
