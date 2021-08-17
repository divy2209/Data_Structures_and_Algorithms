package MathQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// Checking till the half for a prime number, and if we hit one then check for it conjugate to be prime
// Uses less heap memory and equivalent time
public class Prime_sum {
	static ArrayList<Integer> primeSum(int n){
		ArrayList<Integer> ans = new ArrayList<Integer>(2);
		for(int i = 2; i<n/2; i++) {
			boolean flag = true;
			for(int j = 2; j<Math.sqrt(i); j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				boolean flag2 = true;
				int num = n-i;
				for(int j = 2; j<Math.sqrt(num); j++) {
					if(num%j==0) {
						flag2 = false;
						break;
					}
				}
				if(flag2) {
					ans.add(i);
					ans.add(num);
					break;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(primeSum(n));
	}

}
