package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Maximum_unsorted_subarray {
	static ArrayList<Integer> unsortedSubarray(ArrayList<Integer> A){
		int n = A.size();
        int start = -1, end = -1;
        ArrayList<Integer> ans = new ArrayList<Integer>(2);
        for(int i = 0; i<n-1; i++){
            if(A.get(i)>A.get(i+1)){
                start = i;
                break;
            }
        }
        if(start==-1){
            ans.add(start);
            return ans;
        }
        for(int i = n-1; i>0; i--){
            if(A.get(i-1)>A.get(i)){
                end = i;
                break;
            }
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = start; i<=end; i++){
            max = Math.max(max, A.get(i));
            min = Math.min(min, A.get(i));
        }
        for(int i = 0; i<start; i++){
            if(A.get(i)>min){
                start = i;
                break;
            }
        }
        for(int i = n-1; i>end; i--){
            if(A.get(i)<max){
                end = i;
                break;
            }
        }
        ans.add(start);
        ans.add(end);
        return ans;
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
		ArrayList<Integer> ans = unsortedSubarray(A);
		System.out.println(ans);
	}

}
