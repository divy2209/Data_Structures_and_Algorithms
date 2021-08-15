package ArrayQuestions;

import java.util.Scanner;
import java.util.ArrayList;

public class Find_permutation {
	static ArrayList<Integer> findPermutation(final String A, int B){
		int start = 1, end = 0;
		String point = "I";
		ArrayList<Integer> arr = new ArrayList<Integer>(B);
		for(int i = 0; i<B-1; i++) {
			end++;
			if(A.charAt(i)==point.charAt(0)) {
				for(int j = end; j>=start; j--) arr.add(j);
				start = end+1;
			}
		}
		end++;
		for(int j = end; j>=start; j--) arr.add(j);
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		int B = scan.nextInt();
		scan.close();
		ArrayList<Integer> arr = findPermutation(A, B);
		System.out.println(arr);
	}

}
