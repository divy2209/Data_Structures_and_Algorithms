package BitManipulationQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Minimum value will be found in the adjacent numbers for sure
public class Min_XOR_value {
	static int minXORvalue(ArrayList<Integer> arr) {
		int n = arr.size();
		Collections.sort(arr);
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<n-1; i++) ans = Math.min(ans, arr.get(i)^arr.get(i+1));
		return ans;
	}
	
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(minXORvalue(input()));
	}
}
