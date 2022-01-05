package TreeDataStructureImplementationAndExamples;

//import java.util.ArrayList;

// https://www.youtube.com/watch?v=f-sj7I5oXEI
public class Valid_binary_search_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	// Comparing the inorder of the tree
	/*ArrayList<Integer> arr;
	public Valid_binary_search_tree() {
		// TODO Auto-generated constructor stub
		arr = new ArrayList<>();
	}
	int isValidBST(TreeNode root) {
		inOrder(root);
		for(int i = 1; i<arr.size(); i++) {
			if(arr.get(i)<=arr.get(i-1)) return 0;
		}
		return 1;
	}
	void inOrder(TreeNode root) {
		if(root!=null) {
			inOrder(root.left);
			arr.add(root.data);
			inOrder(root.right);
		}
	}*/
	boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	boolean isValidBST(TreeNode root, int max, int min) {
		if(root==null) return true;
		if(root.data>=max || root.data<=min) return false;
		return isValidBST(root, root.data, min) && isValidBST(root, max, root.data);
	}
}
