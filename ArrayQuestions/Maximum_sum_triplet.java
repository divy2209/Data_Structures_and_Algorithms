package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Maximum_sum_triplet {
	static Scanner scan = new Scanner(System.in);
	
	static int solve(ArrayList<Integer> A) {
        int sum = 0;
        for(int i = 1; i<A.size()-1; i++){
            int max1 = 0;
            int max2 = 0;

            for(int j = 0; j<i; j++){
                if(A.get(i)>A.get(j)){
                    max1 = Math.max(max1, A.get(j));
                }
            }
            for(int j = i+1; j<A.size(); j++){
                if(A.get(i)<A.get(j)){
                    max2 = Math.max(max2, A.get(j));
                }
            }
            if(max1>0 && max2>0) {
            	sum = Math.max(sum, max1+A.get(i)+max2);
            }
            
        }
        return sum;
    }
	
	static ArrayList<Integer> Input(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scan.nextInt();
		ArrayList<Integer> A = Input(n);
		int sum = solve(A);
		System.out.println(sum);
	}

}
