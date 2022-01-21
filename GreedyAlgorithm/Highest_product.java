package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Highest_product {
	static int maxProduct3(ArrayList<Integer> arr) {
		Collections.sort(arr);
		int n = arr.size();
		int allPositive = arr.get(n-1)*arr.get(n-2)*arr.get(n-3);
		int twoNegative = arr.get(0)*arr.get(1)*arr.get(n-1);
		return Math.max(allPositive, twoNegative);
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(maxProduct3(input()));
	}
}
