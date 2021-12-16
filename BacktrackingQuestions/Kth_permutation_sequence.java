package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=W9SIlE2jhBQ
// https://www.interviewbit.com/discussion/p/iterative-java-soln/40017/
public class Kth_permutation_sequence {
	static String num = "";
	static void permute(ArrayList<Long> fact, ArrayList<Integer> digits, int n, int k) {
		if(n==0) return;
		long f = fact.get(n-1);
		long index = (long)k/f;
		if(k%f==0) index--;
		num = num+digits.get((int)index).toString();
		digits.remove((int)index);
		k = (int)((long)k-f*index);
		permute(fact, digits, n-1, k);
	}
	static String kthPermutation(int n, int k) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		ArrayList<Long> fact = new ArrayList<Long>();
		long f = 1;
		fact.add((long)1);
		boolean flag = true;
		// issue with the fact, remember this
		for(int i = 1; i<=n; i++) {
			digits.add(i);
			if(flag) {
				f*=i;
				if(f<k) fact.add(f);
				else {
					fact.add((long)(k+1));
					flag = false;
				}
			} else fact.add((long)(k+1));
		}
		num="";
		permute(fact, digits, n, k);
		return num;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		scan.close();
		System.out.println(kthPermutation(n, k));
	}
}
