package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.geeksforgeeks.org/find-starting-indices-substrings-string-s-made-concatenating-words-listl/
public class Substring_concatenation {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> substringConcatenation(ArrayList<String> arr, String s){
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		int l = arr.get(0).length();
		int total = l*arr.size();
		if(total>s.length()) return ans;
		for(int i = 0; i<arr.size(); i++) {
			if(map.containsKey(arr.get(i))) map.put(arr.get(i), map.get(arr.get(i))+1);
			else map.put(arr.get(i), 1);
		}
		for(int i = 0; i<=s.length()-total; i++) {
			HashMap<String, Integer> hmap = new HashMap<>(map);
			int j = i, count = arr.size();
			while(j<i+total) {
				String temp = s.substring(j, j+l);
				if(!hmap.containsKey(temp) || hmap.get(temp)==0) break;
				else {
					hmap.put(temp, hmap.get(temp)-1);
					count--;
				}
				j+=l;
			}
			if(count==0) ans.add(i);
		}
		return ans;
	}
	static ArrayList<String> input(){
		int n = scan.nextInt();
		ArrayList<String> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.next());
		}
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<String> arr = input();
		String s = scan.next();
		scan.close();
		System.out.println(substringConcatenation(arr, s));
	}
}
