package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.interviewbit.com/discussion/p/simple-c-hashing/45874/
// https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
// https://www.youtube.com/watch?v=svMdY6wlQ6I
public class Longest_subarray_length {
	static int longestSubarrayLength(ArrayList<Integer> arr) {
		int len = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(sum, -1);
		for(int i = 0; i<arr.size(); i++) {
			if(arr.get(i)==0) sum--;
			else sum++;
			
			if(sum==1) len=i+1;
			else if(!map.containsKey(sum)) map.put(sum, i);
			
			if(map.containsKey(sum-1)) {
				if(len<i-map.get(sum-1)) len = i-map.get(sum-1);
			}
		}
		return len;
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
		System.out.println(longestSubarrayLength(input()));
	}
}
