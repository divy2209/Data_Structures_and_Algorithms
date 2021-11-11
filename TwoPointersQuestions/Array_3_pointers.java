package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=3WGMZBq_jns
public class Array_3_pointers {
	static Scanner scan = new Scanner(System.in);
	static int minOfMaxOfAbsDiff(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
		int n1 = a.size(), n2 = b.size(), n3 = c.size();
		int i = 0, j = 0, k = 0;
		int ans = Integer.MAX_VALUE;
		while(i<n1 && j<n2 && k<n3) {
			int t = Math.max(Math.abs(a.get(i)-b.get(j)), Math.abs(b.get(j)-c.get(k)));
			t = Math.max(t, Math.abs(c.get(k)-a.get(i)));
			ans = Math.min(ans, t);
			
			if(a.get(i)<=b.get(j) && a.get(i)<=c.get(k)) i++;
			else if(b.get(j)<=c.get(k) && b.get(j)<=a.get(i)) j++;
			else k++;
		}
		return ans;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(minOfMaxOfAbsDiff(input(), input(), input()));
		scan.close();
	}
}
