package TreeDataStructure;

// https://www.youtube.com/watch?v=FvYiXGKfwjI
public class Sum_root_to_leaf_numbers {
	class TreeNode {
		int data;
		TreeNode left, right;
	}
	static int ans = 0;
	static int mod = 1003;
	public Sum_root_to_leaf_numbers() {
		// TODO Auto-generated constructor stub
		ans = 0;
	}
	static int sumRootToLeaf(TreeNode root) {
		traverse(root, 0);
		return ans;
	}
	static void traverse(TreeNode root, int n) {
		if(root==null) return;
		n = ((n*10)%mod+root.data)%mod;
		if(root.left==null && root.right==null) {
			ans+=n;
			ans%=mod;
			return;
		}
		traverse(root.left, n);
		traverse(root.right, n);
	}
}
