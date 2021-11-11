package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=uI9Et1_SvfM
public class Counting_subarrays {
	static Scanner scan = new Scanner(System.in);
	static int countSubarrays(ArrayList<Integer> arr, int b) {
		int n = arr.size();
		int i = 0, j = 0;
		int ans = 0;
		while(j<n) {
			b-=arr.get(j);
			if(b<=0) {
				while(b<=0) b+=arr.get(i++);
			}
			ans+=j-i+1;
			j++;
		}
		return ans;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(countSubarrays(input(), scan.nextInt()));
		scan.close();
	}
}
