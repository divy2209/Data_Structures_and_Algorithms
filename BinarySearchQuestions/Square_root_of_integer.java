package BinarySearchQuestions;

import java.util.Scanner;

// https://www.techiedelight.com/find-square-root-using-binary-search-algorithm/
public class Square_root_of_integer {
	static int sqrt(int a) {
		if(a<2) return a;
		
		long start = 1;
		long end = a/2;
		long result = 0;
		
		while(start<=end) {
			long mid = start+(end-start)/2;
			long n = mid*mid;
			if(n==a) {
				result = mid;
				break;
			} else if(n<a) {
				start = mid+1;
				// we need to take floor, smaller integer. Eg. A = 11, we will return 3 and 3*3 is 9<11 but 4*4=16>11, so we updated the lower value in case we didn't find the exact, we'll have a lower one
				result = mid;
			} else end = mid-1;
		}
		return (int)result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.close();
		System.out.println(sqrt(a));
	}
}
