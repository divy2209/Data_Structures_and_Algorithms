package BinarySearchQuestions;

import java.util.Scanner;

// https://www.youtube.com/watch?v=010oyzd3m2o
public class Implement_power_function {
	static int power(int x, int n, int d) {
		if(x==0) return 0;
		if(n==0) return 1;
		long res = 1;
		long num = (long)x%d;
		while(n>0) {
			if(n%2==1) res = (res*num)%d;
			num = (num*num)%d;
			n/=2;
		}
		if(res<0) res = (long)d+res;
		return (int)res;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int n = scan.nextInt();
		int d = scan.nextInt();
		scan.close();
		System.out.println(power(x, n, d));
	}
}
