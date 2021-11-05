package StringsQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class multiply_strings {
	static String multiplyStrings(String a, String b) {
		if(a.equals("0") || b.equals("0")) return "0";
		for(int i = 0; i<a.length(); i++) {
			if((a.charAt(i)-'0')==0) continue;
			else {
				a = a.substring(i);
				break;
			}
		}
		for(int i = 0; i<b.length(); i++) {
			if((b.charAt(i)-'0')==0) continue;
			else {
				b = b.substring(i);
				break;
			}
		}
		StringBuilder as = new StringBuilder(a);
		as.reverse();
		a = as.toString();
		StringBuilder bs = new StringBuilder(b);
		bs.reverse();
		b = bs.toString();
		String ans = "";
		
		int n = a.length();
		int m = b.length();
		ArrayList<Integer> temp = new ArrayList<Integer>(Collections.nCopies(n+m, 0));
		int lindex = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				int t = (a.charAt(i)-'0')*(b.charAt(j)-'0');
				temp.set(i+j, t+temp.get(i+j));
				lindex = Math.max(i+j, lindex);
			}
		}
		int carry = 0;
		for(int i = 0; i<=lindex; i++) {
			int t = temp.get(i)+carry;
			carry = t/10;
			ans = Integer.toString(t%10) + ans;
		}
		if(carry!=0) {
			ans = Integer.toString(carry) + ans;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		System.out.println(multiplyStrings(a, b));
	}
}
