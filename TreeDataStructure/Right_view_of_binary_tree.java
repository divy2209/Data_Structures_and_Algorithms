package TreeDataStructure;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
// We can do this using level traversal also, and get the last elements
public class Right_view_of_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static ArrayList<Integer> ans = new ArrayList<>();
	public Right_view_of_binary_tree() {
		// TODO Auto-generated constructor stub
		ans.clear();
	}
	static ArrayList<Integer> rightView(TreeNode root){
		traverse(root, 0);
		return ans;
	}
	static void traverse(TreeNode root, int i) {
		if(root==null) return;
		if(ans.size()<i) ans.add(root.data);
		traverse(root.right, i+1);
		traverse(root.left, i+1);
	}
}
