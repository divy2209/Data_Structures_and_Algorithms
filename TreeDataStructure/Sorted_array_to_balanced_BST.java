package TreeDataStructure;

// https://www.youtube.com/watch?v=npaJxQYMad0
public class Sorted_array_to_balanced_BST {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left=right=null;
		}
	}
	static TreeNode constructBalancedBST(int[] arr) {
		return construct(arr, 0, arr.length-1);
	}
	static TreeNode construct(int[] arr, int i, int j) {
		if(i>j) return null;
		int mid = (i+j)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = construct(arr, i, mid-1);
		root.right = construct(arr, mid+1, j);
		return root;
	}
}
