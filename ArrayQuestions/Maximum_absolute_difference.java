package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Maximum_absolute_difference {
	
	static int maxAbsDiff(ArrayList<Integer> A) {
		int n = A.size();
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            max1 = Math.max(max1, A.get(i) + i);
            max2 = Math.max(max2, -A.get(i) + i);

            min1 = Math.min(min1, A.get(i) + i);
            min2 = Math.min(min2, -A.get(i) + i);
        }

        int max_diff = Math.max(max1-min1, max2-min2);
        return max_diff;
	}
	
	static ArrayList<Integer> Input() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = Input();
		int max_diff = maxAbsDiff(A);
		System.out.println(max_diff);
	}

}
