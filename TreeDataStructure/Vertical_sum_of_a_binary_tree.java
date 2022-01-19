package TreeDataStructure;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertical_sum_of_a_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int min;
	static ArrayList<Integer> verticalSumOfABinaryTree(TreeNode root){
		map.clear();
		min = Integer.MAX_VALUE;
		verticalAdding(root, 0);
		ArrayList<Integer> ans = new ArrayList<>();
		while(map.containsKey(min)) {
			ans.add(map.get(min));
			min++;
		}
		return ans;
	}
	static void verticalAdding(TreeNode root, int vertical) {
		if(root==null) return;
		map.put(vertical, map.getOrDefault(vertical, 0)+root.data);
		min = Math.min(min, vertical);
		verticalAdding(root.left, vertical-1);
		verticalAdding(root.right, vertical+1);
	}
}
