package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=eUnNw2lR01M
// https://github.com/SrGrace/InterviewBit/blob/master/Backtracking/Permutations.cpp
public class Permutations {
	static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> arr){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		generatePermutations(ans, arr, 0);
		return ans;
	}
	static void generatePermutations(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int index) {
		if(index==arr.size()) {
			ans.add(new ArrayList<>(arr));
			return;
		}
		for(int i = index; i<arr.size(); i++) {
			swap(arr, i, index);
			generatePermutations(ans, arr, index+1);
			swap(arr, i, index);
		}
	}
	static void swap(ArrayList<Integer> arr, int i, int j) {
		int t = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, t);
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(permutations(input()));
	}
}
