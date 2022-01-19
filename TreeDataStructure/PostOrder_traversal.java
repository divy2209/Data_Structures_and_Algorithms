package TreeDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

// https://www.youtube.com/watch?v=ymIjzhVvNFg
// https://github.com/cruxrebels/InterviewBit/blob/master/Trees/PostorderTraversal.cpp
public class PostOrder_traversal {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static ArrayList<Integer> postOrderTraversal(TreeNode root){
		// Using stack and map, if the node does not have right then add or it does have right but it's present in map then add too, else go in the right
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		HashMap<TreeNode, Integer> map = new HashMap<>();
		while(root!=null) {
			s.push(root);
			map.put(root, 1);
			root = root.left;
		}
		while(!s.isEmpty()) {
			TreeNode temp = s.peek();
			if(temp.right!=null && !map.containsKey(temp.right)) {
				temp = temp.right;
				while(temp!=null) {
					s.push(temp);
					map.put(temp, 1);
					temp = temp.left;
				}
				continue;
			}
			ans.add(temp.data);
			s.pop();
		}
		return ans;
	}
	static ArrayList<Integer> postOrderTraversalEfficient(TreeNode root){
		// PostOrder is reverse of Level Order, so doing that
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		if(root==null) return ans;
		s.push(root);
		while(!s.isEmpty()) {
			TreeNode temp = s.pop();
			ans.add(temp.data);
			if(temp.left!=null) s.push(temp.left);
			if(temp.right!=null) s.push(temp.right);
		}
		Collections.reverse(ans);
		return ans;
	}
}
