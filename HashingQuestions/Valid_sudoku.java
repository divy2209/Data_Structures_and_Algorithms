package HashingQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// https://www.youtube.com/watch?v=7gIlJKVK4Ok
public class Valid_sudoku {
	static boolean isSudokuValid(ArrayList<ArrayList<Character>> arr) {
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i<9; i++) {
			ArrayList<Character> temp = new ArrayList<Character>(arr.get(i));
			for(int j = 0; j<9; j++) {
				char c = temp.get(j);
				if(c!='.') {
					// for subgrid, we can use both 3*(i/3) and i/3, both will be unique for each grid, so it's cool
					if(!set.add(c + "in row" + i) || !set.add(c + "in column" + j) || !set.add(c + "in subgrid" + 3*(i/3) + '-' + 3*(j/3))) return false;
				}
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
		System.out.println(isSudokuValid(input()));
	}
}
