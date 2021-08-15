package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Rotate_matrix {
	static void rotate(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		
		// Transpose of matrix
		for(int i = 0; i<n; i++) {
			for(int j = i; j<n; j++) {
				if(i==j) continue;
				int val = a.get(i).get(j);
				a.get(i).set(j,  a.get(j).get(i));
				a.get(j).set(i,  val);
			}
		}
		
		// Reverse of the matrix
		for(int j = 0; j<n/2; j++) {
			for(int i = 0; i<n; i++) {
				int val = a.get(i).get(j);
				a.get(i).set(j, a.get(i).get(n-1-j));
				a.get(i).set(n-1-j, val);
			}
		}
	}
	
	static ArrayList<ArrayList<Integer>> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>(n);
		for(int i = 0; i<n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(n);
			for(int j = 0; j<n; j++) {
				temp.add(scan.nextInt());
			}
			B.add(temp);
		}
		scan.close();
		return B;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> a = input();
		rotate(a);
		System.out.println(a);
	}

}
