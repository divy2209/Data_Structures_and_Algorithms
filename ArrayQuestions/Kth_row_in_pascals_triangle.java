package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Kth_row_in_pascals_triangle {
	static int binomial(int n, int k) {
		if(k==0||k==n) {
			return 1;
		}
		if(k>n-k) {
			k = n-k;
		}
		int ans = 1;
		for(int i = 0; i<k; i++) {
			ans*=n-i;
			ans/=i+1;
		}
		return ans;
	}
	
	static ArrayList<Integer> kPascalrow(int A){
		ArrayList<Integer> B = new ArrayList<Integer>(A+1);
		for(int i = 0; i<=A; i++) {
			B.add(binomial(A, i));
		}
		return B;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		ArrayList<Integer> B = kPascalrow(A);
		System.out.println(B);
	}

}
