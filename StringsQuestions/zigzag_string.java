package StringsQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class zigzag_string {
	static String zigzagString(String a, int row) {
		if(row==1 || row>=a.length()) return a;
		int n = a.length();
		ArrayList<String> arr = new ArrayList<String>(Collections.nCopies(row, ""));
		int k = 0;
		boolean flag = true;
		for(int i = 0; i<n; i++) {
			arr.set(k, arr.get(k)+Character.toString(a.charAt(i)));
			/*if(flag) {
				if(k+1<row) {
					k++;
				} else {
					k--;
					flag = false;
				}
			} else {
				if(k-1>=0) {
					k--;
				} else {
					k++;
					flag = true;
				}
			}*/
			if(k+1==row) {
				k--;
				flag = false;
			} else if(k==0) {
				k++;
				flag = true;
			} else if(flag) k++;
			else k--;
		}
		
		String ans = "";
		for(int i = 0; i<row; i++) {
			ans+=arr.get(i);
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		int row = scan.nextInt();
		scan.close();
		System.out.println(zigzagString(a, row));
	}
}
