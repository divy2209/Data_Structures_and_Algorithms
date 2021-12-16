package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class All_possible_combinations {
	static ArrayList<String> allPossibleSpecialStrings(ArrayList<String> arr){
		ArrayList<String> ans = new ArrayList<String>();
		generateAllSpecialStrings(ans, arr, "", 0);
		return ans;
	}
	static void generateAllSpecialStrings(ArrayList<String> ans, ArrayList<String> arr, String temp, int index) {
		if(temp.length()==arr.size()) {
			ans.add(temp);
			return;
		}
		for(int i = 0; i<arr.get(index).length(); i++) {
			// i is iterating through a string in arr and index is iterating through all the strings in arr, and letting choose 1 char from each
			generateAllSpecialStrings(ans, arr, temp+arr.get(index).charAt(i), index+1);
		}
	}
	static ArrayList<String> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<String> arr = new ArrayList<String>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.next());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(allPossibleSpecialStrings(input()));
	}
}
