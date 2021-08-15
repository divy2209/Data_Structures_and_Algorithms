package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Sort_array_with_squares {
	static ArrayList<Integer> sortSquares(ArrayList<Integer> A){
		int n = A.size();
		int i = 0, j = n-1;
		ArrayList<Integer> B = new ArrayList<Integer>(n);
		while(i<=j) {
			int start = A.get(i)*A.get(i);
			int end = A.get(j)*A.get(j);
			if(start>=end) {
				B.add(0, start);
				i++;
			} else {
				B.add(0, end);
				j--;
			}
		}
		return B;
	}
	
	static ArrayList<Integer> Input() {
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
		// TODO Auto-generated method stub
		ArrayList<Integer> A = Input();
		ArrayList<Integer> B = sortSquares(A);
		System.out.println(B);
	}

}
