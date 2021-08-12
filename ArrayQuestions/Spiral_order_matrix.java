package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Spiral_order_matrix {
	static ArrayList<ArrayList<Integer>> spiral(int A){
		int[][] temp = new int[A][A];
		int rows = 0, rowe = A-1, cols = 0, cole = A-1, count = 1;
		while(rows<=rowe && cols<=cole) {
			for(int i = cols; i<=cole; i++) {
				temp[rows][i] = count;
				count++;
			}
			rows++;
			for(int i = rows; i<=rowe; i++) {
				temp[i][cole] = count;
				count++;
			}
			cole--;
			for(int i = cole; i>=cols; i--) {
				temp[rowe][i] = count;
				count++;
			}
			rowe--;
			for(int i = rowe; i>=rows; i--) {
				temp[i][cols] = count;
				count++;
			}
			cols++;
		}
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>(A);
		for(int i = 0; i<A; i++) {
			ArrayList<Integer> ltemp = new ArrayList<Integer>(A);
			for(int j = 0; j<A; j++) {
				ltemp.add(temp[i][j]);
			}
			B.add(ltemp);
		}
		return B;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		ArrayList<ArrayList<Integer>> B = spiral(A);
		System.out.println(B);
	}

}
