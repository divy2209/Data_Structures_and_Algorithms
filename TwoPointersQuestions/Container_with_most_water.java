package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=Uj3gJjg6SXc
public class Container_with_most_water {
	static int maxWater(ArrayList<Integer> arr) {
		int n = arr.size();
		int ans = Integer.MIN_VALUE;
		int i = 0, j = n-1;
		while(i<j) {
			int t = (j-i)*((int)Math.min(arr.get(i), arr.get(j)));
			ans = Math.max(ans, t);
			if(arr.get(i)<arr.get(j)) i++;
			else j--;
		}
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
		System.out.println(maxWater(input()));
	}
}
