package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.youtube.com/watch?v=_yGf2rxwZlA
// https://github.com/SrGrace/InterviewBit/blob/master/Hashing/LargestContinuousSequenceZeroSum.cpp
public class Largest_continuous_sequence_zero_sum {
	static ArrayList<Integer> largestContinuousSequenceZeroSum(ArrayList<Integer> arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0, start = -1, end = -1, len = Integer.MIN_VALUE;
		map.put(sum, -1);
		for(int i = 0; i<arr.size(); i++) {
			sum+=arr.get(i);
			if(map.containsKey(sum)) {
				if(len<i-map.get(sum)) {
					start = map.get(sum)+1;
					end = i;
					len = i-map.get(sum);
				}
			} else map.put(sum, i);
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(start>=0 && end>=0) {
			for(int i = start; i<=end; i++) {
				ans.add(arr.get(i));
			}
		}
		return ans;
	}
	static ArrayList<Integer> input(){
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
		System.out.println(largestContinuousSequenceZeroSum(input()));
	}
}
