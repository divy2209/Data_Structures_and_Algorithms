package TreeDataStructure;

// https://www.youtube.com/watch?v=SrTydnU2aj8
public class Flatten_binary_tree_to_linked_list {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static TreeNode flattenBinaryTreeToLinkedList(TreeNode root) {
		helper(root);
		return root;
	}
	static TreeNode helper(TreeNode root) {
		if(root==null) return null;
		if(root.left==null && root.right==null) return root;
		
		TreeNode ltail = helper(root.left);
		TreeNode rtail = helper(root.right);
		
		if(ltail!=null && rtail!=null) {
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = null;
			ltail.right = temp;
			return rtail;
		} else if(ltail!=null) {
			root.right = root.left;
			root.left = null;
			return ltail;
		}
		return rtail;
	}
}
