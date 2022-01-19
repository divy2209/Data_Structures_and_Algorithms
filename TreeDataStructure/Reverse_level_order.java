package TreeDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// https://www.youtube.com/watch?v=gaypFb5sFao
public class Reverse_level_order {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static ArrayList<Integer> ans = new ArrayList<>();
	public Reverse_level_order() {
		// TODO Auto-generated constructor stub
		ans.clear();
	}
	static ArrayList<Integer> reverseLevelOrderEfficient(TreeNode root){
		// Same with looping
		ArrayList<Integer> arr = new ArrayList<>();
		if(root==null) return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int n = q.size();
			for(int i = 0; i<n; i++) {
				TreeNode temp = q.poll();
				arr.add(temp.data);
				if(temp.right!=null) q.add(temp.right);
				if(temp.left!=null) q.add(temp.left);
			}
		}
		Collections.reverse(arr);
		return arr;
	}
	static ArrayList<Integer> reverseLevelOrder(TreeNode root){
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		reverseLevel(q);
		return ans;
	}
	static void reverseLevel(Queue<TreeNode> q) {
		// Once the backtracking is complete, then it will start adding to the array
		if(q.isEmpty()) return;
		Queue<TreeNode> qt = new LinkedList<>();
		int n = q.size();
		for(int i = 0; i<n; i++) {
			TreeNode temp = q.poll();
			if(temp.left!=null) qt.add(temp.left);
			if(temp.right!=null) qt.add(temp.right);
			q.add(temp);
		}
		reverseLevel(qt);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			ans.add(temp.data);
		}
	}
}
