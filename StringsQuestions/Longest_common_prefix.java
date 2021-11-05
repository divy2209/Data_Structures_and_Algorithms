package StringsQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Longest_common_prefix {
	static String longestCommonPrefix(ArrayList<String> A) {
		int n = A.size();
		String ans = A.get(0);
		for(int i = 0; i<n; i++) {
			String str = A.get(i);
			int l = ans.length();
			if(l>str.length()) {
				l = str.length();
				ans = ans.substring(0, l);
			}
			if(!ans.equals(str.substring(0, l))) {
				for(int j = 0; j<l; j++) {
					if(ans.charAt(j)!=str.charAt(j)) {
						ans = ans.substring(0,j);
						break;
					}
				}
			}
		}
		return ans;
	}
	
	static ArrayList<String> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<String> A = new ArrayList<String>(n);
		for(int i = 0; i<n; i++) {
			A.add(scan.next());
		}
		scan.close();
		return A;
	}
	
	public static void main(String[] args) {
		ArrayList<String> A = input();
		System.out.println(longestCommonPrefix(A));
	}
}
