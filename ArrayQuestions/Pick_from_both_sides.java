package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Pick_from_both_sides {
	static Scanner scan = new Scanner(System.in);
	static int maxSum(ArrayList<Integer> A, int B) {
		int sum = 0, ans = 0, i;
		for(i = 0; i<B; i++) {
			sum = sum + A.get(i);
		}
		ans = sum;
		i--;
		int j = A.size()-1;
		int run = 0;
		while(run!=B) {
			sum = sum - A.get(i) + A.get(j);
			i--;
			j--;
			if(sum>ans) {
				ans = sum;
			}
			run++;
		}
		return ans;
	}
	static ArrayList<Integer> Input() {
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = Input();
		int B = scan.nextInt();
		int sum = maxSum(A, B);
		System.out.println(sum);
		scan.close();
	}

}
