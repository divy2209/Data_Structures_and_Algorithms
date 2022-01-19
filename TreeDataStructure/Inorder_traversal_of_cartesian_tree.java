package TreeDataStructure;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=wv4XfOcIQWg
public class Inorder_traversal_of_cartesian_tree {
	static class TreeNode{
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left=right=null;
		}
	}
	static TreeNode constructCartesianTree(ArrayList<Integer> arr) {
		TreeNode root = construct(arr, 0, arr.size()-1);
		return root;
	}
	static TreeNode construct(ArrayList<Integer> arr, int i, int j) {
		if(i<j) return null;
		int index = maxElement(arr, i, j);
		TreeNode root = new TreeNode(arr.get(index));
		root.left = construct(arr, i, index-1);
		root.right = construct(arr, index+1, j);
		return root;
	}
	static int maxElement(ArrayList<Integer> arr, int i, int j) {
		int ans = Integer.MIN_VALUE;
		int index = -1;
		for(int k = i; k<=j; k++) {
			if(arr.get(k)>ans) {
				ans = arr.get(k);
				index = k;
			}
		}
		return index;
	}
}
