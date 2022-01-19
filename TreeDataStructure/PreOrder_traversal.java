package TreeDataStructure;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrder_traversal {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static ArrayList<Integer> preOrderTraversal(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		while(root!=null) {
			ans.add(root.data);
			s.push(root);
			root = root.left;
		}
		while(!s.isEmpty()) {
			TreeNode temp = s.pop();
			temp = temp.right;
			while(temp!=null) {
				ans.add(temp.data);
				s.push(temp);
				temp = temp.left;
			}
		}
		return ans;
	}
}
