package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=hzueK-imcXg
public class Maximum_ones_after_modification {
	static Scanner scan = new Scanner(System.in);
	static int maxOnesFlipMethod(ArrayList<Integer> arr, int b) {
		// In this method, once the zero limit is reached, we move the back pointer forward to the next zero. This has better time complexity
		int n = arr.size();
		int i = 0, j = 0, ans = 0, flip = 0;
		while(i<n) {
			if(arr.get(i)==0) flip++;
			while(flip>b) {
				if(arr.get(j)==0) flip--;
				j++;
			}
			ans = Math.max(ans, i-j+1);
			i++;
		}
		return ans;
	}
	static int maxOnesAfterFlips(ArrayList<Integer> arr, int b) {
		// In this method, once the zero limit is reached, j moves back a lot. This works but not the best complexity
		int n = arr.size();
		int zero = 0, i = 0, j=0;
		int count = 0, ans = 0;
		while(j<n) {
			if(arr.get(j)==1) {
				count++;
				j++;
			} else if(arr.get(j)==0&&zero<b) {
				if(zero==0) i=j+1;
				count++;
				zero++;
				j++;
			} else {
				j=i;
				ans = Math.max(ans, count);
				count=0;
				zero=0;
			}
		}
		ans = Math.max(ans, count);
		return ans;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		//System.out.println(maxOnesAfterFlips(input(), scan.nextInt()));
		System.out.println(maxOnesFlipMethod(input(), scan.nextInt()));
	}
}
