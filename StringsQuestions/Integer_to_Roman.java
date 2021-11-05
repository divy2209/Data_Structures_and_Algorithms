package StringsQuestions;

import java.util.Scanner;

public class Integer_to_Roman {
	static String mapRoman(int n) {
		String[] thousands = new String[] {"", "M", "MM", "MMM"};
		String[] hundreds = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] tens = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] units = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		
		return thousands[n/1000] + hundreds[(n%1000)/100] + tens[(n%100)/10] + units[n%10];
	}
	static String computeRoman(int n) {
		String res = "";
		if(n>=1000) {
			int t = n/1000;
			for(int i = 0; i<t; i++) {
				res+="M";
			}
			n%=1000;
		}
		
		if(n>=100) {
			if(n/100==9) {
				res+="CM";
			} else if(n>=500) {
				int t = (n%500)/100;
				res+="D";
				for(int i = 0; i<t; i++) {
					res+="C";
				}
			} else if(n/100==4) {
				res+="CD";
			} else {
				int t = n/100;
				for(int i = 0; i<t; i++) {
					res+="C";
				}
			}
			
			n%=100;
		}
		
		if(n>=10) {
			if(n/10==9) {
				res+="XC";
			} else if(n>=50) {
				int t = (n%50)/10;
				res+="L";
				for(int i = 0; i<t; i++) {
					res+="X";
				}
			} else if(n/10==4) {
				res+="XL";
			} else {
				int t = n/10;
				for(int i = 0; i<t; i++) {
					res+="X";
				}
			}
			
			n%=10;
		}
		
		if(n==9) {
			res+="IX";
		} else if(n>=5) {
			int t = n%5;
			res+="V";
			for(int i = 0; i<t; i++) {
				res+="I";
			}
		} else if(n==4) {
			res+="IV";
		} else {
			int t = n;
			for(int i = 0; i<t; i++) {
				res+="I";
			}
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(computeRoman(n));
		System.out.println(mapRoman(n));
	}
}
