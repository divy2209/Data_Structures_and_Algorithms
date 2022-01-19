package TreeDataStructure;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=fpjfjNh658c
public class Shortest_unique_prefix {
	static class Trie{
		int freq;
		Trie[] leaf = new Trie[26];
		Trie() {
			freq=0;
			for(int i = 0; i<26; i++) leaf[i]=null;
		}
	}
	static void insert(String str, Trie root) {
		int n = str.length();
		for(int i = 0; i<n; i++) {
			char c = str.charAt(i);
			int k = c-'a';
			if(root.leaf[k]==null) root.leaf[k]=new Trie();
			root.leaf[k].freq++;
			root = root.leaf[k];
		}
	}
	static String find(String str, Trie root) {
		int n = str.length();
		String res = "";
		for(int i = 0; i<n; i++) {
			char c = str.charAt(i);
			int k = c-'a';
			res+=c;
			if(root.leaf[k].freq==1) break;
			root = root.leaf[k];
		}
		return res;
	}
	static ArrayList<String> shortestUniquePrefix(ArrayList<String> arr){
		Trie root = new Trie();
		for(int i = 0; i<arr.size(); i++) insert(arr.get(i), root);
		ArrayList<String> ans = new ArrayList<>();
		for(int i = 0; i<arr.size(); i++) {
			String res = find(arr.get(i), root);
			ans.add(res);
		}
		return ans;
	}
	static ArrayList<String> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<String> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.next());
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(shortestUniquePrefix(input()));
	}
}
