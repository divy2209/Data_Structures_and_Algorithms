package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Intersection_of_sorted_arrays {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> intersectingValues(ArrayList<Integer> a, ArrayList<Integer> b){
		int i = 0, j = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(i<a.size() && j<b.size()) {
			if(a.get(i)<b.get(j)) i++;
			else if(b.get(j)<a.get(i)) j++;
			else {
				ans.add(a.get(i));
				i++;
				j++;
			}
		}
		return ans;
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
		System.out.println(intersectingValues(a, b));
	}
}
