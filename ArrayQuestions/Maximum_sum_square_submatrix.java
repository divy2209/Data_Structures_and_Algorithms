package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Maximum_sum_square_submatrix {
	static Scanner scan = new Scanner(System.in);
	static int maxSum(ArrayList<ArrayList<Integer>> A, int B) {
		int n = A.size();
		int[][] arr = new int[n+1][n+1];
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				arr[i][j] = A.get(i-1).get(j-1) + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}
		int maxsum = Integer.MIN_VALUE;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(i-B>=0 && j-B>=0) {
					int sum = arr[i][j] - arr[i-B][j] - arr[i][j-B] + arr[i-B][j-B];
					maxsum =  Math.max(maxsum, sum);
				}
			}
		}
		return maxsum;
	}
	
	static ArrayList<ArrayList<Integer>> input(){
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>(n);
		for(int i = 0; i<n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(n);
			for(int j = 0; j<n; j++) {
				temp.add(scan.nextInt());
			}
			B.add(temp);
		}
		return B;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> A = input();
		int B = scan.nextInt();
		scan.close();
		int msum = maxSum(A, B);
		System.out.println(msum);
	}

}
