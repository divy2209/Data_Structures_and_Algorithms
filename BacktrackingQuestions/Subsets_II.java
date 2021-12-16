package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=T_5eYs-Npg4
public class Subsets_II {
	static ArrayList<ArrayList<Integer>> subsetsII(ArrayList<Integer> arr){
		Collections.sort(arr);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		//ans.add(new ArrayList<>());
		generateSubsets(ans, new ArrayList<>(), arr, 0);
		return ans;
	}
	static void generateSubsets(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, ArrayList<Integer> arr, int index) {
		//if(index==arr.size()) return;
		ans.add(new ArrayList<>(temp));
		for(int i = index; i<arr.size(); i++) {
			// repeated values will be considered once in each cycle, to avoid duplicate entries
			if(i>index && arr.get(i)==arr.get(i-1)) continue;
			temp.add(arr.get(i));
			generateSubsets(ans, temp, arr, i+1);
			temp.remove(temp.size()-1);	
		}
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
		System.out.println(subsetsII(input()));
	}
}
