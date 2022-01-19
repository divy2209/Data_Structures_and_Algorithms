package TreeDataStructure;

import java.util.Stack;

// https://www.youtube.com/watch?v=4L5seG1d2dA
// This is just an iterative method of inOrder, not a recursive
// apart from that, not the whole order at once
public class BST_iterator {
	class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	static Stack<TreeNode> s = new Stack<>();
	public BST_iterator(TreeNode root) {
		// TODO Auto-generated constructor stub
		s.clear();
		iterate(root);
	}
	static void iterate(TreeNode root) {
		while(root!=null) {
			s.push(root);
			root = root.left;
		}
	}
	static boolean hasNext() {
		return !s.isEmpty();
	}
	static int next() {
		TreeNode temp = s.pop();
		iterate(temp.right);
		return temp.data;
	}
}
