package BitManipulationQuestions;

import java.util.Scanner;

// https://www.youtube.com/watch?v=kU5G5-6xEF4
public class Count_total_set_bits {
	static int countSetBits(int a) {
		if(a==0) return 0;
		long mod = 1000000007, ans = 0;
		long p = 0;
		while(Math.pow(2,p)<=a) p++;
		p--;
		ans+=p*Math.pow(2, p)/2 + (a-Math.pow(2, p)+1) + (long)countSetBits(a-(int)Math.pow(2, p));
		return (int)(ans%mod);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.close();
		System.out.println(countSetBits(a));
	}
}
