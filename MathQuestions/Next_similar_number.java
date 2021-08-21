package MathQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// O(n) solution, iterating only once, during that iteration finding the sequence ascending or desecding and the number to be swapped with
public class Next_similar_number {
	static String nextNum(String A) {
		int n = A.length();
		String ans = "";
		ArrayList<Integer> num = new ArrayList<Integer>(n);
		int k = 0, e = 0;
		int diff = Integer.MAX_VALUE;
		int p = Character.getNumericValue(A.charAt(0));
		for(int i = 0; i<n; i++) {
			num.add(Character.getNumericValue(A.charAt(i)));
			if(i!=0) {
				if(num.get(i-1)<num.get(i)) {
					k = i;
					diff = num.get(i) - num.get(i-1);
					p = num.get(i-1);
					e = i;
				} else {
					int temp = num.get(i)-p;
					if(diff>=temp&&temp>0) {
						diff = temp;
						e = i;
					}
				}
			}
		}
		if(k==0) return "-1";
		if(k==n-1) {
			int t = num.get(n-1);
			num.set(n-1, num.get(n-2));
			num.set(n-2, t);
			ans = A.substring(0, k-1);
			ans = ans + Integer.toString(num.get(k-1)) + Integer.toString(num.get(k));
			return ans;
		}
		num.set(k-1, num.get(e));
		num.set(e, p);
		if(n>3) ans = A.substring(0, k-1);
		ans+=Integer.toString(num.get(k-1));
		for(int i = n-1; i>=k; i--) {
			ans+=Integer.toString(num.get(i));
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(nextNum(A));
	}

}
