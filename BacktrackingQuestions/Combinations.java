package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://github.com/SrGrace/InterviewBit/blob/master/Backtracking/Combinations.cpp
public class Combinations {
	static ArrayList<ArrayList<Integer>> combinations(int n, int k){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		generateCombinations(ans, new ArrayList<Integer>(), n, k, 1);
		return ans;
	}
	static void generateCombinations(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int n, int k, int start) {
		if(k==0) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		if(k<0) return;
		/*if(k<0 || start>n) return;
		ArrayList<Integer> curr = new ArrayList<>(temp);
		curr.add(start);
		generateCombinations(ans, curr, n, k-1, start+1);
		generateCombinations(ans, temp, n, k, start+1);*/
		for(int i = start; i<=n; i++) {
			temp.add(i);
			generateCombinations(ans, temp, n, k-1, i+1);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		scan.close();
		System.out.println(combinations(n, k));
	}
}
