package TreeDataStructure;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=YYyqSB83XJU
public class Root_to_leaf_path_with_sum {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	public Root_to_leaf_path_with_sum() {
		// TODO Auto-generated constructor stub
		ans.clear();
	}
	static ArrayList<ArrayList<Integer>> rootToLeafWithSum(TreeNode root, int n){
		traverse(root, n, 0, new ArrayList<>());
		return ans;
	}
	static void traverse(TreeNode root, int n, int sum, ArrayList<Integer> arr) {
		if(root==null) return;
		ArrayList<Integer> temp = new ArrayList<>(arr);
		sum+=root.data;
		temp.add(root.data);
		if(root.left==null&&root.right==null) {
			if(sum==n) ans.add(temp);
			return;
		}
		traverse(root.left, n, sum, temp);
		traverse(root.right, n, sum, temp);
	}
}
