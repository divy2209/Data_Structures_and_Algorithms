package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=d9F1aO_idyE
public class Palindrome_partitioning {
	static ArrayList<ArrayList<String>> palindromePatitioning(String str){
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		generatePalindromeSubsets(ans, str, new ArrayList<String>());
		return ans;
	}
	static void generatePalindromeSubsets(ArrayList<ArrayList<String>> ans, String str, ArrayList<String> temp) {
		if(str.isEmpty()) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for(int i = 1; i<=str.length(); i++) {
			String left = str.substring(0,i);
			String right = str.substring(i);
			if(isPalindrome(left)) {
				ArrayList<String> curr = new ArrayList<>(temp);
				curr.add(left);
				generatePalindromeSubsets(ans, right, curr);
			}
		}
	}
	static boolean isPalindrome(String s) {
		int l = 0, r = s.length()-1;
		while(l<=r && s.charAt(l)==s.charAt(r)) {
			l++;
			r--;
		}
		return l>=r;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(palindromePatitioning(str));
	}
}
