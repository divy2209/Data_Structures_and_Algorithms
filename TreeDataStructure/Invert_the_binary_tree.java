package TreeDataStructure;

// https://www.youtube.com/watch?v=uqKH8NR1va0
public class Invert_the_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static TreeNode invertTheBinaryTree(TreeNode root) {
		/*if(root==null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTheBinaryTree(root.left);
        invertTheBinaryTree(root.right);*/
		invert(root);
		return root;
	}
	static void invert(TreeNode root) {
		if(root==null) return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invert(root.left);
		invert(root.right);
	}
}
