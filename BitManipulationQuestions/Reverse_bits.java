package BitManipulationQuestions;

import java.util.Scanner;

public class Reverse_bits {
	static long reverseBits(long a) {
		long b = 0;
		for(int i = 0; i<32; i++) {
			b<<=1;
			b|=a&1;
			a>>=1;
		}
		return b;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long a = scan.nextLong();
		scan.close();
		System.out.println(reverseBits(a));
	}
}
