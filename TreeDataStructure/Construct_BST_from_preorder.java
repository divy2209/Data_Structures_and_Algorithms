package TreeDataStructure;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
public class Construct_BST_from_preorder {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left = right = null;
		}
	}
	static int index = 0;
	static TreeNode constructBSTFromPreorder(ArrayList<Integer> preorder) {
		index = 0;
		return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, preorder.get(index));
		//return construct(preorder, 0, preorder.size()-1);
	}
	static TreeNode construct(ArrayList<Integer> pre, int min, int max, int key) {
		// O(n) approach, a little higher
		if(index>=pre.size()) return null;
		TreeNode root = null;
		if(key>min && key<max) {
			root = new TreeNode(key);
			index++;
			root.left = construct(pre, min, key, pre.get(index));
			root.right = construct(pre, key, max, pre.get(index));
		}
		return root;
	}
	static TreeNode construct(ArrayList<Integer> pre, int i, int j) {
		// O(n2) approach and a basic one
		if(i>j || j>=pre.size() || i>=pre.size()) return null;
		TreeNode root = new TreeNode(pre.get(i));
		int index = i+1;
		for(int k = i+1; k<=j; k++) {
			if(pre.get(k)>pre.get(i)) {
				index = k;
				break;
			}
		}
		root.left = construct(pre, i+1, index-1);
		root.right = construct(pre, index, j);
		return root;
	}
}
