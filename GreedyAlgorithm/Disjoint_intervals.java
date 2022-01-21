package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.geeksforgeeks.org/maximal-disjoint-intervals/
// https://www.youtube.com/watch?v=VavHRCO1sSo
public class Disjoint_intervals {
	static int disjointIntervals(ArrayList<ArrayList<Integer>> arr) {
		Collections.sort(arr,(a,b)->a.get(1)-b.get(1));
		int n = arr.size();
		int count = 1;
		int prev = 0;
		for(int i = 0; i<n; i++) {
			if(arr.get(i).get(0)>arr.get(prev).get(1)) {
				count++;
				prev = i;
			}
		}
		return count;
	}
	static ArrayList<ArrayList<Integer>> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
		for(int i = 0; i<n; i++) {
			ArrayList<Integer> temp = new ArrayList<>(2);
			temp.add(scan.nextInt());
			temp.add(scan.nextInt());
			arr.add(temp);
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(disjointIntervals(input()));
	}
}
