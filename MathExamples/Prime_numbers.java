package MathExamples;

import java.util.ArrayList;
import java.util.Scanner;

public class Prime_numbers {
	static ArrayList<Integer> primeNumbers(int A){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(A==1) return ans;
		for(int i = 2; i<=A; i++) {
			boolean flag = true;
			for(int j = 2; j<=Math.sqrt(i); j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			if(flag) ans.add(i);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		ArrayList<Integer> ans = primeNumbers(A);
		System.out.println(ans);
	}

}
