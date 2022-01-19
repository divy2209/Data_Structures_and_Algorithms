package TreeDataStructure;

// https://www.youtube.com/watch?v=dKz9E5CYE4k
public class Remove_half_nodes {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static TreeNode removeHalfNodes(TreeNode root) {
		if(root==null) return root;
		if(root.left==null&&root.right==null) return root;
		else if(root.left==null) return removeHalfNodes(root.right);
		else if(root.right==null) return removeHalfNodes(root.left);
		root.left = removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		return root;
	}
	static void remove(TreeNode root) {
		if(root==null) return;
		if(root.left==null&&root.right==null) return;
		else if(root.left==null) root = root.right;
	}
}
