package BitManipulationQuestions;

import java.util.Scanner;

public class trailing_zeroes {
	static int TrailingBitZeroes(int a) {
		int count = 0;
		/*while(a>0) {
			if(a%2==0) count++;
			else break;
			a = a>>1;
		}*/
		while((a&1)==0 && a>0) {
			count++;
			a = a>>1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.close();
		System.out.println(TrailingBitZeroes(a));
	}
}
