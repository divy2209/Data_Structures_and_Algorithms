package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.youtube.com/watch?v=btjG9eLNYcg
public class Maximum_sum_combinations {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> maximumSumCombinations(ArrayList<Integer> a, ArrayList<Integer> b, int k){
		int n = a.size();
		Collections.sort(a);
		Collections.sort(b);
		PriorityQueue<pair> q = new PriorityQueue<>(new com());
		HashSet<String> set = new HashSet<>();
		ArrayList<Integer> ans = new ArrayList<>(k);
		q.add(new pair(a.get(n-1)+b.get(n-1), n-1, n-1));
		set.add(Integer.toString(n-1) + " " + Integer.toString(n-1));
		while(ans.size()!=k) {
			pair temp = q.poll();
			int data = temp.data, i = temp.i, j = temp.j;
			ans.add(data);
			
			if(i>0 && !set.contains(Integer.toString(i-1) + " " + Integer.toString(j))) {
				q.add(new pair(a.get(i-1)+b.get(j), i-1, j));
				set.add(Integer.toString(i-1) + " " + Integer.toString(j));
			}
			if(j>0 && !set.contains(Integer.toString(i) + " " + Integer.toString(j-1))) {
				q.add(new pair(a.get(i)+b.get(j-1), i, j-1));
				set.add(Integer.toString(i) + " " + Integer.toString(j-1));
			}
		}
		return ans;
	}
	static ArrayList<Integer> input(int n){
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		int n = scan.nextInt();
		ArrayList<Integer> a = input(n);
		ArrayList<Integer> b = input(n);
		int k = scan.nextInt();
		scan.close();
		System.out.println(maximumSumCombinations(a, b, k));
	}
}
class pair{
	int data, i, j;
	pair(int data, int i, int j){
		this.data = data;
		this.i = i;
		this.j = j;
	}
}
class com implements Comparator<pair>{
	public int compare(pair p1, pair p2) {
		if(p1.data==p2.data) return 0;
		else if(p1.data>p2.data) return -1;
		else return 1;
	}
}
