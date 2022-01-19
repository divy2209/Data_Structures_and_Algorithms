package TreeDataStructure;

public class Consecutive_parent_child {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int count;
	static int consecutiveParentChild(TreeNode root) {
		count = 0;
		counting(root);
		return count;
	}
	static void counting(TreeNode root) {
		if(root==null) return;
		if(root.left!=null && Math.abs(root.data-root.left.data)==1) count++;
		if(root.right!=null && Math.abs(root.data-root.right.data)==1) count++;
		counting(root.left);
		counting(root.right);
	}
}
