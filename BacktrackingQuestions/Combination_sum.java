package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=yFfv03AE_vA
// https://coduber.com/combination-sum-python-java-and-c-solution/
public class Combination_sum {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target){
		Collections.sort(arr);
		for(int i = 0; i<arr.size(); i++) {
			if(i>0) {
				if(arr.get(i-1)==arr.get(i)) {
					arr.remove(i);
					i--;
				}
			}
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		generateCombinationTargetSum(ans, arr, target, 0, new ArrayList<Integer>());
		return ans;
	}
	static void generateCombinationTargetSum(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int target, int start, ArrayList<Integer> temp /*curr*/) {
		//1- ArrayList<Integer> temp = new ArrayList<Integer>(curr);
		if(target==0) {
			//1- ans.add(temp);
			ans.add(new ArrayList<Integer>(temp));
			return;
		} else if(target<0) return;
		
		/*for(int i = start; i<arr.size(); i++) {
			temp.add(arr.get(i));
			generateCombinationTargetSum(ans, arr, target-arr.get(i), i, temp);
			temp.remove(temp.size()-1);
		}*/
		// Instead of using loop, using two recursion, one with updated list and next one with old list and incremented start
		ArrayList<Integer> curr = new ArrayList<Integer>(temp);
		curr.add(arr.get(start));
		generateCombinationTargetSum(ans, arr, target-arr.get(start), start, curr);
		if(start+1<arr.size()) generateCombinationTargetSum(ans, arr, target, start+1, temp);
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
		int targer = scan.nextInt();
		scan.close();
		System.out.println(combinationSum(arr, targer));
	}
}
