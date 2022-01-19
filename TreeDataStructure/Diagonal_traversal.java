package TreeDataStructure;

import java.util.ArrayList;
import java.util.HashMap;

// https://www.youtube.com/watch?v=OXJCeMUIqa0
public class Diagonal_traversal {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	public Diagonal_traversal() {
		// TODO Auto-generated constructor stub
		map.clear();
	}
	static ArrayList<Integer> diagonalTraversal(TreeNode root){
		inOrder(root, 0);
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i<map.size(); i++) {
			ArrayList<Integer> temp = map.get(i);
			ans.addAll(temp);
		}
		return ans;
	}
	static void inOrder(TreeNode root, int diag) {
		if(root==null) return;
		ArrayList<Integer> temp = map.getOrDefault(diag, new ArrayList<>());
		temp.add(root.data);
		map.put(diag, temp);
		inOrder(root.left, diag+1);
		inOrder(root.right, diag);
	}
}
