package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Anti_diagonals {
	static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A){
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        int n = A.size();
        int[][] temp = new int[n][n];
        for(int i = 0; i<n; i++){
            ArrayList<Integer> tempi = A.get(i);
            for(int j = 0; j<n; j++){
                temp[i][j] = tempi.get(j);
            }
        }
        for(int i = 0; i<n; i++) {
        	int col = i, row = 0;
        	ArrayList<Integer> ltemp = new ArrayList<Integer>();
        	while(col>=0) {
        		ltemp.add(temp[row][col]);
        		row++;
        		col--;
        	}
        	B.add(ltemp);
        }
        for(int i = 1; i<n; i++) {
        	int col = n-1, row = i;
        	ArrayList<Integer> ltemp = new ArrayList<Integer>();
        	while(row<n) {
        		ltemp.add(temp[row][col]);
        		row++;
        		col--;
        	}
        	B.add(ltemp);
        }
        return B;
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
		ArrayList<ArrayList<Integer>> B = input();
		ArrayList<ArrayList<Integer>> ans = diagonal(B);
		System.out.println(ans);
	}

}
