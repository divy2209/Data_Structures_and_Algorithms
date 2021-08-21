package MathQuestions;

import java.util.Scanner;

public class Reverse_integer {
	static int revese(int n) {
		int rev = 0;
		while(n!=0) {
			int temp = rev*10 + n%10;
			if((temp-n%10)/10!=rev) return 0;
			else rev = temp;
			n/=10;
		}
		return rev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(revese(n));
	}

}
