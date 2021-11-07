package BitManipulationQuestions;

import java.util.Scanner;

// https://www.youtube.com/watch?v=yE_9Bp6bbiw
// https://www.youtube.com/watch?v=QYoWR8hDCyQ&t=1s
public class Palindromic_binary_representation {
	static int reverse(int ans) {
		int b = 0;
		while(ans>0) {
			b<<=1;
			b|=ans&1;
			ans>>=1;
		}
		return b;
	}
	
	static int palindrome(int a) {
		if(a==1) return 1;
		int count = 1, len=1;
		int p = 0;
		while(count<a) {
			len++;
			if(len%2==0) p=(len-2)/2;
			else p=len/2;
			count+=(int)Math.pow(2, p);
		}
		count-=(int)Math.pow(2,p);
		int ans = (int)Math.pow(2, len-1);
		int next = a-count-1;
		ans|=next*(int)Math.pow(2, len/2);
		ans|=reverse(ans);
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.close();
		System.out.println(palindrome(a));
	}
}
