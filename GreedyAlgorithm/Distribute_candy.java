package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://github.com/cruxrebels/InterviewBit/blob/master/Greedy/DistributeCandy.cpp
public class Distribute_candy {
	static int distributeCandies(ArrayList<Integer> arr) {
		int candies = 0, n = arr.size();
		ArrayList<Integer> leftToRight = new ArrayList<>(Collections.nCopies(n, 1));
		ArrayList<Integer> rightToLeft = new ArrayList<>(Collections.nCopies(n, 1));
		for(int i = 1; i<n; i++) {
			if(arr.get(i)>arr.get(i-1)) leftToRight.set(i, leftToRight.get(i-1)+1);
		}
		for(int i = n-2; i>=0; i--) {
			if(arr.get(i)>arr.get(i-1)) rightToLeft.set(i, rightToLeft.get(i+1)+1);
		}
		for(int i = 0; i<n; i++) candies = Math.max(leftToRight.get(i), rightToLeft.get(i));
		return candies;
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
		System.out.println(distributeCandies(input()));
	}
}
