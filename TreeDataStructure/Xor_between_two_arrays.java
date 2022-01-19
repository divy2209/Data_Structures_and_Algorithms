package TreeDataStructure;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=OUNfpFswJq8
public class Xor_between_two_arrays {
	static class Trie{
		Trie left, right;
		Trie(){
			left = right = null;
		}
	}
	static Scanner scan = new Scanner(System.in);
	static void insert(int n, Trie root) {
		int bitl = 30;
		while(bitl>=0) {
			int bit = ((1<<bitl)&n)>0?1:0;
			if(bit==0) {
				if(root.left==null) root.left = new Trie();
				root = root.left;
			} else {
				if(root.right==null) root.right = new Trie();
				root = root.right;
			}
			bitl--;
		}
	}
	static int find(int n, Trie root) {
		int bitl = 30;
		int ans = 0;
		while(bitl>=0) {
			int bit = ((1<<bitl)&n)>0?1:0;
			ans=ans<<1;
			if(bit==0) {
				if(root.left==null) {
					ans++;
					root = root.right;
				} else root = root.left;
			} else {
				if(root.right==null) root = root.left;
				else {
					ans++;
					root = root.right;
				}
			}
		}
		return ans;
	}
	static int xorBetweenTwoArrays(ArrayList<Integer> a, ArrayList<Integer> b) {
		Trie root = new Trie();
		for(int i = 0; i<a.size(); i++) insert(a.get(i), root);
		int max = 0;
		for(int i = 0; i<b.size(); i++) {
			int temp = b.get(i)^Integer.MAX_VALUE;
			int res = find(temp, root);
			max = Math.max(max, res^b.get(i));
		}
		return max;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> a = input();
		ArrayList<Integer> b = input();
		scan.close();
		System.out.println(xorBetweenTwoArrays(a, b));
	}
}
