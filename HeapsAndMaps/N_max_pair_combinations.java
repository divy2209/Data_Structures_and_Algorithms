package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.youtube.com/watch?v=btjG9eLNYcg
public class N_max_pair_combinations {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> nMaxPairCombinations(ArrayList<Integer> a, ArrayList<Integer> b){
		int n = a.size();
		Collections.sort(a);
		Collections.sort(b);
		PriorityQueue<Threepair> q = new PriorityQueue<>(new comp());
		HashSet<String> set = new HashSet<>();
		ArrayList<Integer> ans = new ArrayList<>(n);
		q.add(new Threepair(a.get(n-1)+b.get(n-1), n-1, n-1));
		set.add(Integer.toString(n-1) + " " + Integer.toString(n-1));
		while(ans.size()!=n) {
			Threepair temp = q.poll();
			int data = temp.data, i = temp.i, j = temp.j;
			ans.add(data);
			
			if(i>0 && !set.contains(Integer.toString(i-1) + " " + Integer.toString(j))) {
				q.add(new Threepair(a.get(i-1)+b.get(j), i-1, j));
				set.add(Integer.toString(i-1) + " " + Integer.toString(j));
			}
			if(j>0 && !set.contains(Integer.toString(i) + " " + Integer.toString(j-1))) {
				q.add(new Threepair(a.get(i)+b.get(j-1), i, j-1));
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
		scan.close();
		System.out.println(nMaxPairCombinations(a, b));
	}
}
class Threepair{
	int data, i, j;
	Threepair(int data, int i, int j){
		this.data = data;
		this.i = i;
		this.j = j;
	}
}
class comp implements Comparator<Threepair>{
	public int compare(Threepair a, Threepair b) {
		if(a.data==b.data) return 0;
		// max heap
		else if(a.data>b.data) return -1;
		else return 1;
	}
}