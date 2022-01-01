package HashingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// https://github.com/cruxrebels/InterviewBit/blob/master/Hashing/Anagrams.cpp
// https://stackoverflow.com/questions/605891/sort-a-single-string-in-java/605902
// https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
public class Anagrams {
	static ArrayList<ArrayList<Integer>> anagrams(ArrayList<String> arr){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for(int i = 0; i<arr.size(); i++) {
			String str = sortString(arr.get(i));
			if(!map.containsKey(str)) map.put(str, new ArrayList<Integer>());
			map.get(str).add(i+1);
		}
		for(ArrayList<Integer> temp : map.values()) {
			res.add(temp);
		}
		return res;
	}
	static String sortString(String str) {
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
	static ArrayList<String> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<String> arr = new ArrayList<String>(n);
		for(int i = 0; i<n;i++) {
			arr.add(scan.next());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(anagrams(input()));
	}
}
