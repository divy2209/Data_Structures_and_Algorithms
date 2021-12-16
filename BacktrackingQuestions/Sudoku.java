package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=JzONv5kaPJM
// https://www.youtube.com/watch?v=uyetDh-DyDg
// https://github.com/cruxrebels/InterviewBit/blob/master/Backtracking/Sudoku.cpp
public class Sudoku {
	static void sudokuSolution(ArrayList<ArrayList<Character>> arr){
		generateSudokuSolution(arr, 0, 0);
	}
	static boolean generateSudokuSolution(ArrayList<ArrayList<Character>> arr, int row, int col) {
		if(row==9) return true;
		int nrow, ncol;
		if(col==8) {
			nrow = row+1;
			ncol = 0;
		} else {
			nrow = row;
			ncol = col+1;
		}
		if(arr.get(row).get(col)!='.') {
			if(!isValid(arr, row, col)) return false;
			return generateSudokuSolution(arr, nrow, ncol);
		}
		for(int i = 1; i<=9; i++) {
			arr.get(row).set(col, Integer.toString(i).charAt(0));
			if(isValid(arr, row, col) && generateSudokuSolution(arr, nrow, ncol)) {
				return true;
			}
		}
		arr.get(row).set(col, '.');
		return false;
	}
	static boolean isValid(ArrayList<ArrayList<Character>> arr, int row, int col) {
		char ch = arr.get(row).get(col);
		for(int i = 0; i<9; i++) {
			if(arr.get(row).get(i)==ch && i!=col) return false;
			if(arr.get(i).get(col)==ch && i!=row) return false;
		}
		// To get the starting index of the subgrid
		//int r = row - row%3;
		//int c = col - col%3;
		int r = 3*(row/3);
		int c = 3*(col/3);
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(i+r==row && j+c==col) continue;
				if(arr.get(r+i).get(c+j)==ch/* && (i+r!=row || j+c!=col)*/) return false;
			}
		}
		return true;
	}
	static ArrayList<ArrayList<Character>> input(){
		Scanner scan = new Scanner(System.in);
		ArrayList<ArrayList<Character>> arr = new ArrayList<ArrayList<Character>>(9);
		for(int i = 0; i<9; i++) {
			ArrayList<Character> temp = new ArrayList<Character>(9);
			for(int j = 0; j<9; j++) {
				temp.add(scan.next().charAt(0));
			}
			arr.add(temp);
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Character>> ans = input();
		sudokuSolution(ans);
		System.out.println(ans);
	}
}

/*
5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9

. 5 3 2 . 7 . . 8
6 . 1 5 . . . . 2
2 . . 9 1 3 . 5 .
7 1 4 6 9 2 . . .
. 2 . . . . . 6 .
. . . 4 5 1 2 9 7
. 6 . 3 2 5 . . 9
1 . . . . 6 3 . 4
8 . . 1 . 9 6 7 .

3 . 6 5 . 8 4 . .
5 2 . . . . . . .
. 8 7 . . . . 3 1
. . 3 . 1 . . 8 .
9 . . 8 6 3 . . 5
. 5 . . 9 . 6 . .
1 3 . . . . 2 5 .
. . . . . . . 7 4
. . 5 2 . 6 3 . .
*/
