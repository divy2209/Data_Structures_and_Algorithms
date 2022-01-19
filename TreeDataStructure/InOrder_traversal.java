package TreeDataStructure;

import java.util.ArrayList;
import java.util.Stack;

public class InOrder_traversal {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static ArrayList<Integer> inOrderTraversal(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		while(root!=null) {
			s.push(root);
			root = root.left;
		}
		while(!s.isEmpty()) {
			TreeNode temp = s.pop();
			ans.add(temp.data);
			temp = temp.right;
			while(temp!=null) {
				s.push(temp);
				temp = temp.left;
			}
		}
		return ans;
	}
}
