package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.interviewbit.com/discussion/p/c-subarray-with-b-odd-numbers-o-n-unordered-map/57450/
// https://www.geeksforgeeks.org/number-subarrays-m-odd-numbers/
public class Subarray_with_B_odd_numbers {
	static Scanner scan = new Scanner(System.in);
	static int subarraysWithBOdd(ArrayList<Integer> arr, int b) {
		int odd = 0, count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<arr.size(); i++) {
			if(map.containsKey(odd)) map.put(odd, map.get(odd)+1);
			else map.put(odd, 1);
			//if(arr.get(i)%2==1) odd++;
			odd+=arr.get(i)%2;
			if(odd>=b && map.containsKey(odd-b)) count+=map.get(odd-b);
		}
		return count;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int b = scan.nextInt();
		scan.close();
		System.out.println(subarraysWithBOdd(arr, b));
	}
}
