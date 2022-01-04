package HeapsAndMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.youtube.com/watch?v=aWC8bJ4GrSI
public class Distinct_numbers_in_window {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> distinctNumbersInWindow(ArrayList<Integer> arr, int b){
		int n = arr.size();
		ArrayList<Integer> ans = new ArrayList<>();
		if(b>n) return ans;
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for(int i = 0; i<n; i++) {
			if(count==b) {
				ans.add(map.size());
				int t = map.get(arr.get(i-b));
				if(t==1) map.remove(arr.get(i-b));
				else map.put(arr.get(i-b), t-1);
				map.put(arr.get(i), map.getOrDefault(arr.get(i), 0)+1);
			} else {
				map.put(arr.get(i), map.getOrDefault(arr.get(i), 0)+1);
				count++;
			}
		}
		ans.add(map.size());
		return ans;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = input();
		int b = scan.nextInt();
		scan.close();
		System.out.println(distinctNumbersInWindow(arr, b));
	}
}
