package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.geeksforgeeks.org/count-pairs-given-xor/
// https://www.javatpoint.com/java-xor
// https://www.interviewbit.com/discussion/p/very-simple-code/59304/
public class Pairs_with_given_XOR {
	static Scanner scan = new Scanner(System.in);
	static int countPairsWithGivenXOR(ArrayList<Integer> arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for(int i = 0; i<arr.size(); i++) {
			if(map.containsKey(arr.get(i))) count++;
			else map.put(arr.get(i)^k, 1);
		}
		return count;
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
		int k = scan.nextInt();
		scan.close();
		System.out.println(countPairsWithGivenXOR(arr, k));
	}
}
