package TreeDataStructure;

// https://www.youtube.com/watch?v=tb4dbeCNZwQ
public class Path_sum {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int pathSum(TreeNode root, int n) {
		return traverse(root, n, 0)?1:0;
	}
	static boolean traverse(TreeNode root, int n, int sum) {
		if(root==null) return false;
		sum+=root.data;
		if(root.left==null && root.right==null) {
			if(sum==n) return true;
		}
		return traverse(root.left, n, sum)||traverse(root.right, n, sum);
	}
}
