package TreeDataStructure;

public class Max_depth_of_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int ans = -1;
	public Max_depth_of_binary_tree() {
		// TODO Auto-generated constructor stub
		ans = -1;
	}
	static int maxDepthEfficient(TreeNode root) {
		if(root==null) return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		return 1+Math.max(l, r);
	}
	static int maxDepth(TreeNode root) {
		traverse(root, 0);
		return ans;
	}
	static void traverse(TreeNode root, int n) {
		ans = Math.max(ans, n);
		if(root==null) return;
		traverse(root.left, n+1);
		traverse(root.right, n+1);
	}
}
