package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.youtube.com/watch?v=zxPJltIldWU
// https://www.geeksforgeeks.org/comparator-interface-java/
// https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/
public class Merge_k_sorted_arrays {
	static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arr){
		int n = arr.size();
		int k = arr.get(0).size();
		PriorityQueue<three> q = new PriorityQueue<three>(n, new comparator());
		for(int i = 0; i<n; i++) q.add(new three(arr.get(i).get(0), i, 0));
		ArrayList<Integer> ans = new ArrayList<>(n*k);
		while(!q.isEmpty()) {
			three temp = q.poll();
			ans.add(temp.val);
			int i = temp.row;
			int j = temp.col+1;
			if(j<k) q.add(new three(arr.get(i).get(j), i, j));
		}
		return ans;
	}
	static ArrayList<ArrayList<Integer>> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
		for(int i = 0; i<n; i++) {
			ArrayList<Integer> temp = new ArrayList<>(k);
			for(int j = 0; j<k; j++) {
				temp.add(scan.nextInt());
			}
			arr.add(temp);
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(mergeKSortedArrays(input()));
	}
}
class three{
	int val, row, col;
	three(int val, int row, int col){
		this.val = val;
		this.row = row;
		this.col = col;
	}
}
class comparator implements Comparator<three>{
	public int compare(three a, three b) {
		if(a.val==b.val) return 0;
		else if(a.val>b.val) return 1;
		else return -1;
	}
}
