package TreeDataStructure;

// https://www.youtube.com/watch?v=hmasyzjIESM
public class Balanced_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int ans;
	public Balanced_binary_tree() {
		// TODO Auto-generated constructor stub
		ans = 1;
	}
	static int balancedBinaryTree(TreeNode root) {
		height(root);
		return ans;
	}
	static int height(TreeNode root) {
		if(root==null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		if(Math.abs(left-right)>1) ans = 0;
		return 1+Math.max(left, right);
	}
}
