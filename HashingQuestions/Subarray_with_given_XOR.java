package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.youtube.com/watch?v=lO9R5CaGRPY
// https://www.interviewbit.com/discussion/p/c-solution-using-unordered-map-and-prefix-xor/61309/
public class Subarray_with_given_XOR {
	static Scanner scan = new Scanner(System.in);
	static int subarraysWithGivenXOR(ArrayList<Integer> arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int pref = 0;
		for(int i = 0; i<arr.size(); i++) {
			pref^=arr.get(i);
			if(pref==k) count++;
			if(map.containsKey(pref^k)) count+=map.get(pref^k);
			map.put(pref, map.containsKey(pref) ? map.get(pref)+1 : 1);
		}
		return count;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int k = scan.nextInt();
		scan.close();
		System.out.println(subarraysWithGivenXOR(arr, k));
	}
}
