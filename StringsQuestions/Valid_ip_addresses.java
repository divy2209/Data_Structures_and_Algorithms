package StringsQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Valid_ip_addresses {
	static boolean isValidIP(String str) {
		int n = str.length();
		if(n>3) return false;
		else if(str.charAt(0)=='0' && n>1) return false;
		int val = Integer.parseInt(str);
		return val>=0 && val<=255;
	}
	
	static ArrayList<String> listValidIP(String A){
		int n = A.length();
		ArrayList<String> arr = new ArrayList<String>();
		if(n<4) return arr;
		
		for(int i = 1; i<=3 && i<n; i++) {
			String first = A.substring(0,i);
			if(isValidIP(first)) {
				for(int j = 1; j<=3 && i+j<n; j++) {
					String second = A.substring(i, i+j);
					if(isValidIP(second)) {
						for(int k = 1; k<=3 && i+j+k<n; k++) {
							String third = A.substring(i+j, i+j+k);
							String fourth = A.substring(i+j+k);
							if(isValidIP(third) && isValidIP(fourth)) {
								String ip = first + "." + second + "." + third + "." + fourth;
								arr.add(ip);
							}
						}
					}
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		System.out.println(listValidIP(A));
	}
}
