package BinarySearchQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=_reu46LJtyk
public class Matrix_search {
	static Scanner scan = new Scanner(System.in);
	
	static int matrixSearch(ArrayList<ArrayList<Integer>> A, int B) {
		int m = A.size();
		int n = A.get(0).size();
		int i = 0;
		int j = n-1;
		
		while(i<m && j>=0) {
			if(A.get(i).get(j)==B) return 1;
			else if(A.get(i).get(j)>B) j--;
			else i++;
		}
		
		return 0;
	}
	
	static ArrayList<ArrayList<Integer>> input(){
		int m = scan.nextInt();
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(m);
		for(int i = 0; i<m; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>(n);
			for(int j = 0; j<n; j++) {
				a.add(scan.nextInt());
			}
			arr.add(a);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> A = input();
		int B = scan.nextInt();
		scan.close();
		System.out.println(matrixSearch(A, B));
	}

}
