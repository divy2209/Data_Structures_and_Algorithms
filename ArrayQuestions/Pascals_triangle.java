package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Pascals_triangle {
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
	
	static ArrayList<ArrayList<Integer>> pascalTriangle(int A){
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<A; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j<=i; j++) {
				temp.add(binomial(i, j));
			}
			B.add(temp);
		}
		return B;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		ArrayList<ArrayList<Integer>> B = pascalTriangle(A);
		System.out.println(B);
	}

}
