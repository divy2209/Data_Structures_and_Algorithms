package TreeDataStructure;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=7siC3XcaMbs
public class Binary_tree_from_inorder_and_postorder {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left = right = null;
		}
	}
	static TreeNode binaryTreeFromInOrderAndPostOrder(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
		return construct(inorder, 0, inorder.size()-1, postorder, 0, postorder.size()-1);
	}
	static TreeNode construct(ArrayList<Integer> in, int i, int j, ArrayList<Integer> post, int k, int l) {
		if(i>j || k>l) return null;
		int index = getRoot(in, post.get(l), i, j);
		TreeNode root = new TreeNode(post.get(l));
		int left = index-i;
		root.left = construct(in, i, index-1, post, k, k+left-1);
		root.right = construct(in, index+1, j, post, k+left, l-1);
		return root;
	}
	static int getRoot(ArrayList<Integer> in, int n, int i, int j) {
		for(int k = i; k<=j; k++) {
			if(in.get(k)==n) return k;
		}
		return -1;
	}
}
