package MathQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=fUS9G-WG9SQ
public class City_tour {
	static long mod = 1000000007;
	static Scanner scan = new Scanner(System.in);
	
	// permuting the unvisited cities factorial, then unpermuting the gaps by dividing factorial and repermuting the middle gaps by 2^(gapsize-1)
	static int waysCityTour(int A, ArrayList<Integer> B) {
		int n = B.size();
		// number of unvisited cities
		int unvisited = A-n;
		
		// Saving the gaps in a list
		ArrayList<Integer> gaps = new ArrayList<Integer>();
		gaps.add(B.get(0)-1);
		for(int i = 1; i<n; i++) {
			gaps.add(B.get(i)-B.get(i-1)-1);
		}
		gaps.add(A-B.get(n-1));
		
		long ans = 0;
		// factorial of unvisited cities, permuting
		ans = factorial(unvisited);
		// un-permuting the gaps
		for(int i = 0; i<gaps.size(); i++) {
			// Fermet's Little Theorem-- mod with of a inverse
			ans*=(power(factorial(gaps.get(i)), mod-2))%mod;
			ans%=mod;
		}
		
		//permuting the middle gaps by 2^(gapsize-1)
		long z = 1;
		for(int i = 0; i<gaps.size(); i++) {
			if(i==0 || i==gaps.size()-1) continue;
			else {
				z*=power(2, gaps.get(i)-1);
				z%=mod;
			}
		}
		
		ans = (ans*z)%mod;
		return (int)ans;
	}
	
	// Fermet's Little Theorem-- mod with of a inverse
	// (a^-1)%mod = (a^m-2)%mod
	// function to calculate power of a number with a modulo, big numbers
	static long power(long a, long m) {
		if(m==0) return 1;
		else if(m==1) return a;
		else {
			long temp = power(a, m/2)%mod;
			temp = (temp*temp)%mod;
			return (m%2==0) ? temp : (a*temp)%mod;
		}
	}
	
	static long factorial(int n) {
		long fact = 1;
		for(int i = 2; i<=n; i++) {
			fact = (fact*i)%mod;
		}
		return fact;
	}
	
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			a.add(scan.nextInt());
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = scan.nextInt();
		ArrayList<Integer> B = input();
		scan.close();
		System.out.println(waysCityTour(A, B));
	}

}
