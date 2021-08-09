package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Max_sum_contigous_subarray {
	static int maxSumSubarray(ArrayList<Integer> A) {
		int sum = 0, fsum = Integer.MIN_VALUE;
        for(int i = 0; i<A.size(); i++){
            sum = sum + A.get(i);
            if(sum>fsum){
                fsum = sum;
            }
            if(sum<0) {
                sum = 0;
            }
        }
        return fsum;
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
		int sum = maxSumSubarray(A);
		System.out.println(sum);
	}

}
