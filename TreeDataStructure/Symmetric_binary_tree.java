package TreeDataStructure;

public class Symmetric_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int isSymmetric(TreeNode root) {
		return symmetric(root.left, root.right)?1:0;
	}
	static boolean symmetric(TreeNode root1, TreeNode root2) {
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null || root1.data!=root2.data) return false;
		return symmetric(root1.right, root2.left)&&symmetric(root1.left, root2.right);
	}
}
