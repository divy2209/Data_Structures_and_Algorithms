package BacktrackingImplementationAndExamples;

import java.util.Scanner;

// https://www.geeksforgeeks.org/modular-exponentiation-recursive/
public class Modular_expression {
	static int powMod(int n, int p, int mod) {
		if(n==0) return 0;
		if(p==0) return 1;
		
		long y;
		if(p%2==0) {
			y = powMod(n,p/2,mod);
			y = (y*y)%mod;
		} else {
			y = n%mod;
			y = (y*powMod(n,p-1,mod))%mod;
		}
		return (int)((y+mod)%mod);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int p = scan.nextInt();
		int mod = scan.nextInt();
		scan.close();
		System.out.println(powMod(n, p, mod));
	}
}
