package BacktrackingImplementationAndExamples;

import java.util.Scanner;

public class Fibonacci {
	static int[] fib = new int[51];
	static int fibonacciLooping(int n) {
		// Iterative approach, all the values calculated only once
		if(n<=1) return n;
		int f1 = 0, f2 = 1;
		for(int i = 2; i<=n; i++) {
			int f = f1+f2;
			f1 = f2;
			f2 = f;
		}
		return f2;
	}
	static int fibonacciRecursion(int n) {
		// forms a recursion tree, calculating the same value multiple times, using more time, increasing exponentially
		if(n<=1) return n;
		return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);
	}
	static int fibonacciRecursionMemorization(int n) {
		if(fib[n]!=-1) return fib[n];
		fib[n] = fibonacciRecursionMemorization(n-1) + fibonacciRecursionMemorization(n-2);
		return fib[n];
	}
	public static void main(String[] args) {
		for(int i = 0; i<51; i++) {
			fib[i]=-1;
		}
		fib[0] = 0; fib[1] = 1;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		// System.out.println(fibonacciLooping(n));
		//System.out.println(fibonacciRecursion(n));
		System.out.println(fibonacciRecursionMemorization(n));
	}
}
