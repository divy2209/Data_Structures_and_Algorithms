package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=vDNVIJz9RUg
public class NQueens {
	static ArrayList<ArrayList<String>> placingNQueens(int n){
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		if(n==2 || n==3) return ans;
		ArrayList<String> temp = new ArrayList<String>(n);
		String str = "";
		for(int i = 0; i<n; i++) {
			str+='.';
		}
		for(int i = 0; i<n; i++) {
			temp.add(str);
		}
		generatePossiblePositionsNQueens(ans, temp, n, 0);
		return ans;
	}
	static void generatePossiblePositionsNQueens(ArrayList<ArrayList<String>> ans, ArrayList<String> temp, int n, int row) {
		if(row==n) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for(int i = 0; i<n; i++) {
			if(isSafe(n, row, i, temp)) {
				replaceCharString(temp, row, i, 'Q');
				generatePossiblePositionsNQueens(ans, temp, n, row+1);
				replaceCharString(temp, row, i, '.');
			}
		}
	}
	static boolean isSafe(int n, int row, int col, ArrayList<String> temp) {
		for(int k = 0; k<n; k++) {
			// checking all the rows in the given column and all the column in the given row
			if(temp.get(k).charAt(col)=='Q' || temp.get(row).charAt(k)=='Q') return false;
		}
		for(int l = 0; l<n; l++) {
			// Checking for all the diagonals
			if(inBound(row-l, col-l, n) && temp.get(row-l).charAt(col-l)=='Q') return false;
			if(inBound(row-l, col+l, n) && temp.get(row-l).charAt(col+l)=='Q') return false;
			if(inBound(row+l, col-l, n) && temp.get(row+l).charAt(col-l)=='Q') return false;
			if(inBound(row+l, col+l, n) && temp.get(row+l).charAt(col+l)=='Q') return false;
		}
		return true;
	}
	static boolean inBound(int row, int col, int n) {
		if(row<0 || col<0 || row>=n || col>=n) return false;
		return true;
	}
	static void replaceCharString(ArrayList<String> temp, int row, int index, char c) {
		// https://www.geeksforgeeks.org/replace-a-character-at-a-specific-index-in-a-string-in-java/
		String str = temp.get(row);
		str = str.substring(0, index) + c + str.substring(index+1);
		temp.set(row, str);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		ArrayList<ArrayList<String>> ans = placingNQueens(n);
		System.out.println(ans);
	}
}
