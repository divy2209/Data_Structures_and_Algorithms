package BitManipulationQuestions;

import java.util.Scanner;

public class Number_of_1_bits {
	static int Onebitcount(long a) {
		int count = 0;
		while(a>0) {
			//if(a%2==1) count++;
			if((a&1)==1) count++;
			a = a >> 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long a = scan.nextLong();
		scan.close();
		System.out.println(Onebitcount(a));
	}
}
