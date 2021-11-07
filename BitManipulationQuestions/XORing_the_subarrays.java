package BitManipulationQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// Total subarrays are (i+1)*(n-i), if this frequency is even then all XOR's cancelled and if odd then once XOR is required
// By taking the odd even test cases, n=even, all the frequencies is even so no XOR's, and with n=odd, only i=even are valid for XOR
// Do some dry run testing
public class XORing_the_subarrays {
	static int XORing(ArrayList<Integer> arr) {
		int n = arr.size();
		if(n%2==0) return 0;
		int ans = 0;
		for(int i = 0; i<n; i+=2) {
			// (i+1)*(n-i)
			ans^=arr.get(i);
		}
		return ans;
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(XORing(input()));
	}
}
