package TreeDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
// https://www.youtube.com/watch?v=KSmd0qQvNMk
public class Vertical_order_traversal_of_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static class pair {
		TreeNode root;
		int vertical;
		pair(TreeNode root, int vertical){
			this.root = root;
			this.vertical = vertical;
		}
	}
	static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(root==null) return ans;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int k = 0;
		ArrayList<Integer> verticals = new ArrayList<>();
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(root, k));
		while(!q.isEmpty()) {
			pair p = q.poll();
			k = p.vertical;
			if(map.containsKey(k)) {
				ArrayList<Integer> temp = map.get(k);
				temp.add(p.root.data);
				map.put(k, temp);
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(p.root.data);
				verticals.add(k);
				map.put(k, temp);
			}
			if(p.root.left!=null) {
				q.add(new pair(p.root.left, p.vertical-1));
			}
			if(p.root.right!=null) {
				q.add(new pair(p.root.right, p.vertical+1));
			}
		}
		Collections.sort(verticals);
		for(int i = 0; i<verticals.size(); i++) {
			ArrayList<Integer> temp = map.get(verticals.get(i));
			ans.add(temp);
		}
		return ans;
	}
}
