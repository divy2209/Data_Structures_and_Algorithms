package ArrayQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Noble_integer {
	static int nobleInt(ArrayList<Integer> A) {
		Collections.sort(A);
		int n = A.size();
		if(A.get(n-1)==0) return 1;
		for(int i = 0; i<n-1; i++) {
			if(A.get(i)!=A.get(i+1)) {
				int count = n-1-i;
				if(A.get(i)==count) return 1;
			}
		}
		return -1;
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
		int result = nobleInt(A);
		System.out.println(result);
	}

}
