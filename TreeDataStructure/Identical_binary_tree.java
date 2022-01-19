package TreeDataStructure;

public class Identical_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int isIdentical(TreeNode root1, TreeNode root2) {
		return identical(root1, root2)?1:0;
	}
	static boolean identical(TreeNode root1, TreeNode root2) {
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null || root1.data!=root2.data) return false;
		return identical(root1.left, root2.left)&&identical(root1.right, root2.right);
	}
}
