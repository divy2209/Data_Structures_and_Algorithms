package TreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Covered_uncovered_nodes {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static long coveredUncoveredDiff(TreeNode root) {
		long covered = 0;
		long uncovered = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int n = q.size()-1;
			for(int i = 0; i<=n; i++) {
				TreeNode temp = q.poll();
				if(i==n || i==0) uncovered+=(long)temp.data;
				else covered+=(long)temp.data;
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
		}
		return Math.abs(uncovered-covered);
	}
}
