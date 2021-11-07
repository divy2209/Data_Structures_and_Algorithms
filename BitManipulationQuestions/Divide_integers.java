package BitManipulationQuestions;

import java.util.Scanner;

// https://www.youtube.com/watch?v=X2Ko1Jt9bL4
public class Divide_integers {
	static int divideIntegers(int x, int y) {
		long a = x, b = y;
		boolean positive = true;
		if((a>0&&b<0)||(a<0&&b>0)) positive = false;
		if(a<0) a=-a;
		if(b<0) b=-b;
		
		long ans = 0, temp = 0;
		for(int i = 31; i>=0; i--) {
			if(temp+(b<<i)<=a) {
				temp+=(b<<i);
				ans+=((long)1<<i);
			}
		}
		
		if(!positive) ans=-ans;
		if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return (int) ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.close();
		System.out.println(divideIntegers(x, y));
	}
}
