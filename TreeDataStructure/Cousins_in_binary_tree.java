package TreeDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.youtube.com/watch?v=SWo2WtWOBrI
public class Cousins_in_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static ArrayList<Integer> cousinsInBinaryTree(TreeNode root, int b){
		// personal approach
		// Making the level traversal, storing the target's parent, saving that level order and not adding the siblings by keeping a check
		ArrayList<Integer> ans = new ArrayList<>();
		if(root==null || root.data==b) return ans;
		TreeNode target = null;
		boolean values = false;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int n = q.size();
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i = 0; i<n; i++) {
				TreeNode t = q.poll();
				if(target!=null) {
					if(target.left!=null && target.left.data==t.data) continue;
					if(target.right!=null && target.right.data==t.data) continue;
				}
				temp.add(t.data);
				if(t.left!=null) {
					q.add(t.left);
					if(t.left.data==b) target = t;
				}
				if(t.right!=null) {
					q.add(t.right);
					if(t.right.data==b) target = t;
				}
			}
			if(values) {
				ans = temp;
				break;
			}
			if(target!=null) values = true;
		}
		return ans;
	}
}
