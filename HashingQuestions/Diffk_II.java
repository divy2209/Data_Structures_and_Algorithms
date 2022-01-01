package HashingQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// https://github.com/SrGrace/InterviewBit/blob/master/Hashing/Diffk-II.cpp
public class Diffk_II {
	static Scanner scan = new Scanner(System.in);
	static int diffkII(final ArrayList<Integer> arr, int k) {
		if(arr.size()<2 || k<0) return 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<arr.size(); i++) {
			int n1 = arr.get(i)-k;
			int n2 = arr.get(i)+k;
			if(set.contains(n1) || set.contains(n2)) return 1;
			set.add(arr.get(i));
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
		ArrayList<Integer> arr = input();
		int k = scan.nextInt();
		scan.close();
		System.out.println(diffkII(arr, k));
	}
}
