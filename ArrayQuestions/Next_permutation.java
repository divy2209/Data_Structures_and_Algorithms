package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Next_permutation {
	static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
		int n = A.size();
        if(n==1) return A;
        int min = Integer.MIN_VALUE, k = 0;
        for(int i = 0; i<n; i++){
            if(min<A.get(i)){
                k = i;
            }
            min = A.get(i);
        }
        if(k==n-1){
            int val = A.get(n-2);
            A.set(n-2, A.get(n-1));
            A.set(n-1, val);
            return A;
        }
        if(k==0){
            for(int i = 0; i<n/2; i++){
                int val = A.get(i);
                A.set(i, A.get(n-1-i));
                A.set(n-1-i, val);
            }
            return A;
        }
        int pnum = A.get(k-1);
        int l = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = k; i<n; i++){
            if(diff>A.get(i)-pnum&&A.get(i)-pnum>0){
                diff = A.get(i)-pnum;
                l = i;
            }
            if(A.get(i)-pnum<=0 || i == n-1){
                A.set(k-1, A.get(l));
                A.set(l, pnum);
                break;
            }
        }
        int m = k+(n-k)/2;
        int j = 1;
        for(int i = k; i<m; i++){
            int val = A.get(i);
            A.set(i, A.get(n-j));
            A.set(n-j, val);
            j++;
        }
        return A;
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
		A = nextPermutation(A);
		System.out.println(A);
	}

}
