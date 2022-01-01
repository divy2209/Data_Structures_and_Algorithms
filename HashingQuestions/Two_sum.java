package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://github.com/SrGrace/InterviewBit/blob/master/Hashing/2Sum.cpp
// https://www.youtube.com/watch?v=nBcLIdHDxvM
public class Two_sum {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> twoSum(ArrayList<Integer> arr, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>(2);
		for(int i = 0; i<arr.size(); i++) {
			int temp = target-arr.get(i);
			if(map.containsKey(temp)) {
				ans.add(map.get(temp)+1);
				ans.add(i+1);
				return ans;
			}
			if(!map.containsKey(arr.get(i))) map.put(arr.get(i), i);
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
		ArrayList<Integer> arr = input();
		int target = scan.nextInt();
		scan.close();
		System.out.println(twoSum(arr, target));
	}
}
