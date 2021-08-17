package MathExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Factors are in pairs and if they aren't equal to sqrt of num then they both are different in add both
// time complexity decreases to O(n^1/2)
public class All_factors {
	static ArrayList<Integer> allFactors(int A){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 1; i<=Math.sqrt(A); i++) {
			if(A%i==0) {
				ans.add(i);
				if(i!=Math.sqrt(A)) ans.add(A/i);
			}
		}
		Collections.sort(ans);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		System.out.println(allFactors(A));
	}

}
