package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


// https://www.youtube.com/watch?v=PFkUl_rW3_w
public class Combination_sum_II {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<ArrayList<Integer>> combinationSumII(ArrayList<Integer> arr, int target){
		Collections.sort(arr);
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		generateCombinationTargetSumII(set, arr, new ArrayList<Integer>(), 0, target);
		return new ArrayList<>(set);
	}
	static void generateCombinationTargetSumII(Set<ArrayList<Integer>> set, ArrayList<Integer> arr, ArrayList<Integer> temp, int start, int target) {
		if(target==0) {
			set.add(new ArrayList<Integer>(temp));
			return;
		}
		if(target<0) return;
		for(int i = start; i<arr.size(); i++) {
			temp.add(arr.get(i));
			generateCombinationTargetSumII(set, arr, temp, i+1, target-arr.get(i));
			temp.remove(temp.size()-1);
		}
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n ; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int target = scan.nextInt();
		scan.close();
		System.out.println(combinationSumII(arr, target));
	}
}
