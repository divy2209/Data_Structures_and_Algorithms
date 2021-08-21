package MathQuestions;

import java.util.Scanner;

public class Largest_coprime_divisor {
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	static int lcd(int a, int b) {
		while(gcd(a, b)!=1) {
			a/=gcd(a,b);
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		System.out.println(lcd(a, b));
	}

}
