package StringsQuestions;

import java.util.Scanner;

// https://www.youtube.com/watch?v=ZUt8L8cbbBI
public class Add_binary_strings {
	static String addBinaryNumbers(String a, String b) {
		int n1 = a.length();
		int n2 = b.length();
		String res = "";
		
		int i = n1-1, j = n2-1;
		boolean carry = false;
		while(i>=0 && j>=0) {
			if(a.charAt(i)=='1' && b.charAt(j)=='1') {
				if(carry) {
					res = "1"+res;
				} else {
					res = "0"+res;
					carry = true;
				}
			}
			else if(a.charAt(i)=='0' && b.charAt(j)=='0') {
				if(carry) {
					res = "1"+res;
					carry = false;
				} else {
					res = "0" + res;
				}
			}
			else {
				if(carry) {
					res = "0" + res;
				} else {
					res = "1" + res;
				}
			}
			i--;
			j--;
		}
		
		if(i>=0) {
			while(i>=0) {
				if(carry) {
					if(a.charAt(i)=='1') res = "0" + res;
					else {
						res = "1" + res;
						carry = false;
					}
				} else res = Character.toString(a.charAt(i)) + res;
				
				i--;
			}
		} else if(j>=0) {
			while(j>=0) {
				if(carry) {
					if(b.charAt(j)=='1') res = "0" + res;
					else {
						res = "1" + res;
						carry = false;
					}
				} else res = Character.toString(b.charAt(j)) + res;
				
				j--;
			}
		}
		
		if(carry) {
			res = "1" + res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		System.out.println(addBinaryNumbers(a, b));
	}
}
