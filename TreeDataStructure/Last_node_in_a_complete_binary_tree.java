package TreeDataStructure;

//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/delete-the-last-leaf-node-in-a-binary-tree/
public class Last_node_in_a_complete_binary_tree {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int lastNodeInACompleteBinaryTree(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		//ArrayList<Integer> arr = new ArrayList<>();
		int ans = 0;
		while(!q.isEmpty()) {
			//arr.clear();
			int n = q.size();
			while(n>0) {
				TreeNode temp = q.poll();
				//arr.add(temp.data);
				if(n==1) ans = temp.data;
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
				n--;
			}
		}
		//return arr.get(arr.size()-1);
		return ans;
	}
}
