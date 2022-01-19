package TreeDataStructure;

// https://www.youtube.com/watch?v=ndEO0V10aS8
public class Merge_two_binary_tree {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	static TreeNode mergeTwoBinaryTrees(TreeNode root1, TreeNode root2) {
		merge(root1, root2);
		return root1;
	}
	static TreeNode merge(TreeNode root, TreeNode root1, TreeNode root2) {
		// forming a new tree, takes up alot of space and time
		if(root1==null && root2==null) return null;
		if(root1!=null && root2!=null) root = new TreeNode(root1.data+root2.data);
		else if(root1!=null) root = new TreeNode(root1.data);
		else root = new TreeNode(root2.data);
		
		root.left = merge(root.left, root1!=null?root1.left:root1, root2!=null?root2.left:root2);
		root.right = merge(root.right, root1!=null?root1.right:root1, root2!=null?root2.right:root2);
		return root;
	}
	static TreeNode merge(TreeNode root1, TreeNode root2) {
		// add the missing values from 2nd in 1st, better space and time complexity
		if(root1==null && root2==null) return null;
		if(root1!=null && root2!=null) {
			root1.data = root1.data+root2.data;
			root1.left = merge(root1.left, root2.left);
			root1.right = merge(root1.right, root2.right);
			return root1;
		}
		else if(root2!=null) return root2;
		else return root1;
	}
}
