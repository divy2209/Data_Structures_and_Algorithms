package BitManipulationQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// XOR of same number is 0 and XOR with 0 is the same num, using this property we can find the missing num
// https://www.youtube.com/watch?v=VVELme4hzjA
public class Single_integer {
	static int onceAppearingNum(ArrayList<Integer> arr) {
		int n = arr.size();
		int ans = 0;
		for(int i = 0; i<n; i++) ans^=arr.get(i);
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
		System.out.println(onceAppearingNum(input()));
	}
}
