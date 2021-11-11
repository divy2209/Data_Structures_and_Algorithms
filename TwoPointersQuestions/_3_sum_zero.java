package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=2t356ju-PB8
public class _3_sum_zero {
	static ArrayList<ArrayList<Integer>> _3SumZero(ArrayList<Integer> arr){
		int n = arr.size();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Collections.sort(arr);
		for(int i = 0; i<n; i++) {
			if(i>0 && (long)arr.get(i)==(long)arr.get(i-1)) continue;
			int j = i+1, k = n-1;
			while(j<k) {
				long temp = (long)arr.get(i)+(long)arr.get(j)+(long)arr.get(k);
				if(temp==0) {
					ArrayList<Integer> t = new ArrayList<Integer>(3);
					t.add(arr.get(i));
					t.add(arr.get(j));
					t.add(arr.get(k));
					ans.add(t);
					while(j<k && (long)arr.get(j)==(long)arr.get(j+1)) j++;
					while(j<k && (long)arr.get(k)==(long)arr.get(k-1)) k--;
					j++;
					k--;
				} else if(temp>0) k--;
				else j++;
			}
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
		System.out.println(_3SumZero(input()));
	}
}
