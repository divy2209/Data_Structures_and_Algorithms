package HashingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

// https://github.com/varunu28/InterviewBit-Java-Solutions/blob/master/Hashing/4%20Sum.java
public class Four_sum {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> arr, int target){
		Collections.sort(arr);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<arr.size()-3; i++) {
			for(int j = i+1; j<arr.size()-2; j++) {
				int k = j+1, l = arr.size()-1;
				while(k<l) {
					int sum = arr.get(i) + arr.get(j) + arr.get(k) + arr.get(l);
					if(sum>target) l--;
					else if(sum<target) k++;
					else {
						ArrayList<Integer> temp = new ArrayList<Integer>(4);
						temp.add(arr.get(i));
						temp.add(arr.get(j));
						temp.add(arr.get(k));
						temp.add(arr.get(l));
						if(!set.contains(temp)) {
							set.add(temp);
							ans.add(temp);
						}
						k++;
						l--;
					}
				}
			}
		}
		return ans;
		
		/*ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<arr.size()-3; i++) {
			if(i>0 && arr.get(i)==arr.get(i-1)) continue;
			for(int j = i+1; j<arr.size()-2; j++) {
				if(j>i+1 && arr.get(j-1)==arr.get(j)) continue;
				int p1 = j+1, p2 = arr.size()-1;
				while(p2>p1) {
					int sum = arr.get(i) + arr.get(j) + arr.get(p1) + arr.get(p2);
					if(sum==target) {
						ArrayList<Integer> temp = new ArrayList<Integer>(4);
						temp.add(arr.get(i));
						temp.add(arr.get(j));
						temp.add(arr.get(p1));
						temp.add(arr.get(p2));
						ans.add(temp);
						p1++;
						p2--;
						while(p1<p2 && arr.get(p1)==arr.get(p1-1)) p1++;
						while(p1<p2 && arr.get(p2)==arr.get(p2+1)) p2--;
					} else if(sum>target) p2--;
					else p1++;
				}
			}
		}
		return ans;*/
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
		System.out.println(fourSum(arr, target));
	}
}
