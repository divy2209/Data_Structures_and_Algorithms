package TreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Populate_next_right_pointers_tree {
	class TreeLinkNode {
		int data;
		TreeLinkNode left, right, next;
	}
	static TreeLinkNode populateNextRightPointers(TreeLinkNode root) {
		if(root==null) return root;
		Queue<TreeLinkNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int n = q.size();
			for(int i = 0; i<n; i++) {
				TreeLinkNode temp = q.poll();
				if(i==n-1) {
					temp.next = null;
				} else {
					temp.next = q.peek();
				}
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
		}
		return root;
	}
}
