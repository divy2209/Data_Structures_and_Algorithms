package TreeDataStructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=hPVDhNfO1Ng
// https://www.youtube.com/watch?v=GYdC4hQSo8A
public class Valid_BST_from_preorder {
	static int isValidBSTStack(ArrayList<Integer> preorder) {
		Stack<Integer> s = new Stack<>();
		int root = Integer.MIN_VALUE;
		for(int i = 0; i<preorder.size(); i++) {
			while(!s.isEmpty()&&preorder.get(i)>s.peek()) {
				root = s.pop();
			}
			if(preorder.get(i)<root) return 0;
			s.push(preorder.get(i));
		}
		return 1;
	}
	static int isValidBST(ArrayList<Integer> preorder) {
		boolean check = check(preorder, 0, preorder.size()-1);
		return check?1:0;
	}
	static boolean check(ArrayList<Integer> preorder, int l, int r) {
		if(l>=r) return true;
		int i = l+1;
		for(;i<r&&preorder.get(l)>=preorder.get(i);i++);
		for(int j = i; j<r;j++) {
			if(preorder.get(l)>preorder.get(j)) return false;
		}
		boolean left = check(preorder, l+1, i-1);
		boolean right = check(preorder, i, r);
		return left&&right;
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> preorder = new ArrayList<>(n);
		for(int i = 0; i<n; i++) preorder.add(scan.nextInt());
		scan.close();
		return preorder;
	}
	public static void main(String[] args) {
		ArrayList<Integer> preorder = input();
		System.out.println(isValidBST(preorder));
		System.out.println(isValidBSTStack(preorder));
	}
}
