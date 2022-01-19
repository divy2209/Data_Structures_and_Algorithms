package TreeDataStructure;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=FnlsqbEQBcE
public class Construct_binary_tree_from_inorder_and_preorder {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode (int data){
			this.data = data;
			left=right=null;
		}
	}
	static TreeNode constructBinaryTreeFromInOrderAndPreOrder(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
		return construct(inorder, 0, inorder.size()-1, preorder, 0, preorder.size()-1);
	}
	static TreeNode construct(ArrayList<Integer> in, int i, int j, ArrayList<Integer> pre, int k, int l) {
		if(i>j || k>l) return null;
		int index = getRoot(in, pre.get(k), i, j);
		TreeNode root = new TreeNode(pre.get(k));
		int left = index-i;
		root.left = construct(in, i, index-1, pre, k+1, k+left);
		root.right = construct(in, index+1, j, pre, k+left+1, l);
		return root;
	}
	static int getRoot(ArrayList<Integer> in, int n, int i, int j) {
		for(int k = i; k<=j; k++) {
			if(in.get(k)==n) return k;
		}
		return -1;
	}
}
