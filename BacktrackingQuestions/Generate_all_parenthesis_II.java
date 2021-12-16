package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://github.com/cruxrebels/InterviewBit/blob/master/Backtracking/GenerateAllParenthesesII.cpp
public class Generate_all_parenthesis_II {
	static ArrayList<String> allParenthesisII(int n){
		ArrayList<String> ans = new ArrayList<String>();
		generateAllParenthesisII(ans, "", n, 0, 0);
		return ans;
	}
	static void generateAllParenthesisII(ArrayList<String> ans, String temp, int n, int open, int close) {
		if(open>n || close>open) return;
		if(close==n) {
			ans.add(temp);
			return;
		}
		generateAllParenthesisII(ans, temp+'(', n, open+1, close);
		generateAllParenthesisII(ans, temp+')', n, open, close+1);
		
		/*if(close==n) {
			ans.add(temp);
			return;
		} else {
			if(open<n) generateAllParenthesisII(ans, temp+'(', n, open+1, close);
			if(open>close) generateAllParenthesisII(ans, temp+')', n, open, close+1); 
		}*/
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(allParenthesisII(n));
	}
}
