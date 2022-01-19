package TreeDataStructure;

// https://www.youtube.com/watch?v=T6Jr-Q6bvSU
// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class Least_common_ancestor {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int a1 = -1, a2 = -1;
	static int leastCommonAncestor(TreeNode root, int a, int b) {
		/*if(!find(root, a) && !find(root, b)) return -1;
		return commonAncestor(root, a, b).data;*/
		a1 = -1;
		a2 = -1;
		TreeNode ans = commonAncestor(root, a, b);
		if(a1==-1 || a2==-1) return -1;
		return ans.data;
	}
	static TreeNode commonAncestor(TreeNode root, int a, int b) {
		if(root==null) return root;
		//if(root.data==a || root.data==b) return root;
		if(root.data==a) a1 = a;
		if(root.data==b) a2 = b;
		TreeNode l = commonAncestor(root.left, a, b);
		TreeNode r = commonAncestor(root.right, a, b);
		if(root.data==a || root.data==b) return root;
		
		if(l!=null && r!=null) return root;
		return l!=null ? l : r;
	}
	static boolean find(TreeNode root, int n) {
		if(root==null) return false;
		if(root.data==n) return true;
		return find(root.left, n) || find(root.right, n);
	}
}
