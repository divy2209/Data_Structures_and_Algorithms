package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Bulbs {
	static int bulbsMinSwitches(ArrayList<Integer> arr) {
		int n = arr.size();
		int count = 0;
		for(int i = 0; i<n; i++) {
			if(arr.get(i)==0&&count%2==0 || arr.get(i)==1&&count%2==1) {
				arr.set(i, 1);
				count++;
			}
		}
		return count;
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
		System.out.println(bulbsMinSwitches(input()));
	}
}
