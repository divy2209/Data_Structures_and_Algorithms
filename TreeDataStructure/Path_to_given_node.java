package TreeDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=OJMIa90B7Vc
public class Path_to_given_node {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> pathToNode(TreeNode root, int k){
		ArrayList<Integer> ans = new ArrayList<>();
		Collections.reverse(ans);
		while(root!=null) {
			ans.add(root.data);
			if(root.data==k) break;
			else if(root.data>k) root = root.left;
			else root = root.right;
		}
		return ans;
	}
	static boolean preorder(TreeNode root, ArrayList<Integer> ans, int k) {
		if(root==null) return false;
		if(root.data==k || preorder(root.left, ans, k) || preorder(root.right, ans, k)) {
			ans.add(root.data);
			return true;
		}
		return false;
	}
}
