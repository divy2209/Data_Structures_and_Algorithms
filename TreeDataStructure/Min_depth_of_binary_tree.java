package TreeDataStructure;

public class Min_depth_of_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int ans;
	public Min_depth_of_binary_tree() {
		// TODO Auto-generated constructor stub
		ans = Integer.MAX_VALUE;
	}
	static int minDepth(TreeNode root) {
		traverse(root, 0);
		return ans;
	}
	static void traverse(TreeNode root, int n) {
		if(root==null) return;
		if(root.left==null && root.right==null) {
			ans = Math.min(ans, n+1);
			return;
		}
		traverse(root.left, n+1);
		traverse(root.right, n+1);
	}
}
