package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Set_matrix_zeroes {
	static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int m = a.size();
        int n = a.get(0).size();
        boolean frow = false;
        boolean fcol = false;
        for(int i = 0; i<m; i++){
            if(a.get(i).get(0)==0){
                fcol = true;
                break;
            }
        }
        for(int j = 0; j<n; j++){
            if(a.get(0).get(j)==0){
                frow = true;
                break;
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(a.get(i).get(j)==0){
                    a.get(0).set(j, 0);
                    a.get(i).set(0, 0);
                }
            }
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(a.get(i).get(0)==0||a.get(0).get(j)==0) a.get(i).set(j, 0);
            }
        }
        if(frow){
            for(int j = 0; j<n; j++){
                a.get(0).set(j, 0);
            }
        }
        if(fcol){
            for(int i = 0; i<m; i++){
                a.get(i).set(0, 0);
            }
        }
	}
	
	static ArrayList<ArrayList<Integer>> input(){
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>(n);
		for(int i = 0; i<m; i++) {
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
		setZeroes(a);
		System.out.println(a);
	}

}
