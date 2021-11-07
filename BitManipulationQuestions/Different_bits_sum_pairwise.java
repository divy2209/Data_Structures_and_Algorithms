package BitManipulationQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=rsQhs2uJrUg
public class Different_bits_sum_pairwise {
	static int differentBitsSumPairwise(ArrayList<Integer> arr) {
		int n = arr.size();
		long mod = 1000000007;
		long ans = 0;
		for(int i = 0; i<32; i++) {
			long zero = 0, one = 0;
			for(int j = 0; j<n; j++) {
				if((arr.get(j)>>i&1)==0) zero++;
				else one++;
			}
			ans+=one*zero*2;
		}
		return (int)(ans%mod);
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
		System.out.println(differentBitsSumPairwise(input()));
	}
}
