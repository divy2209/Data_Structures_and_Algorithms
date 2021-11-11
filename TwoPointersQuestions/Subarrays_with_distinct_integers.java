package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.youtube.com/watch?v=E-8ISfrYHgU
public class Subarrays_with_distinct_integers {
	static Scanner scan = new Scanner(System.in);
	static int subarraysWithAtmostKDistinct(ArrayList<Integer> arr, int k) {
		HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
		int n = arr.size();
		int i = 0, j = 0, ans = 0;
		while(j<n) {
			mp.put(arr.get(j), mp.getOrDefault(arr.get(j), 0)+1);
			System.out.println(mp + " " + mp.size());
			if(mp.size()>k) {
				while(mp.size()>k) {
					if(mp.containsKey(arr.get(i))) mp.put(arr.get(i), mp.get(arr.get(i))-1);
					//mp.replace(arr.get(i), mp.get(arr.get(i))-1);
					if(mp.get(arr.get(i))==0) {
						mp.remove(arr.get(i));
						break;
						//System.out.println("cleared");
					}
					System.out.println(mp + " " + mp.size());
					i++;
				}
			}
			ans+=j-i+1;
			j++;
		}
		return ans;
	}
	static int countSubarraysWithDistinctNums(ArrayList<Integer> arr, int b) {
		int c1 = subarraysWithAtmostKDistinct(arr, b);
		int c2 = subarraysWithAtmostKDistinct(arr, b-1);
		return c1-c2;
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
		System.out.println(countSubarraysWithDistinctNums(input(), scan.nextInt()));
		scan.close();
	}
}
