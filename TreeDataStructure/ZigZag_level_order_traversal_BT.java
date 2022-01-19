package TreeDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/zigzag-tree-traversal/
public class ZigZag_level_order_traversal_BT {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
		// this is personal approach
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(root==null) return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<>();
			int n = q.size();
			for(int i = 0; i<n; i++) {
				TreeNode t = q.poll();
				temp.add(t.data);
				if(t.left!=null) q.add(t.left);
				if(t.right!=null) q.add(t.right);
			}
			if(ans.size()%2==1) Collections.reverse(temp);
			ans.add(temp);
		}
		return ans;
	}
}
