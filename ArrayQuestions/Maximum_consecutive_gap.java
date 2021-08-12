package ArrayQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//https://www.youtube.com/watch?v=wB-JSSNphI4
//https://www.youtube.com/watch?v=o0vLGxGmmZ4

public class Maximum_consecutive_gap {
	static int maxGap(final List<Integer> A) {
		int n = A.size();
        if(n<2){
            return 0;
        }
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            mx = Math.max(mx, A.get(i));
            mn = Math.min(mn, A.get(i));
        }
        int gap = (mx-mn-1)/(n-1)+1;
        ArrayList<Integer> bucket_min = new ArrayList<Integer>(n);
        ArrayList<Integer> bucket_max = new ArrayList<Integer>(n);
        for(int i = 0; i<n; i++){
            bucket_max.add(Integer.MIN_VALUE);
            bucket_min.add(Integer.MAX_VALUE);
        }
        for(int i = 0; i<n; i++){
            if(mx==A.get(i)||mn==A.get(i)) continue;
            int k = (A.get(i) - mn)/gap;
            int nt = Math.min(bucket_min.get(k), A.get(i));
            int xt = Math.max(bucket_max.get(k), A.get(i));
            bucket_min.set(k, nt);
            bucket_max.set(k, xt);
        }
        int ans = 0;
        int pmax = mn;
        for(int i = 0; i<n-1; i++){
            if(bucket_min.get(i)==Integer.MAX_VALUE) continue;
            ans = Math.max(ans, bucket_min.get(i)-pmax);
            pmax = bucket_max.get(i);
        }
        ans = Math.max(ans, mx-pmax);
        return ans;
	}
	
	static List<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> A = new LinkedList<Integer>();;
		for(int i = 0; i<n; i++) {
			A.add(scan.nextInt());
		}
		scan.close();
		return A;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = input();
		int gap = maxGap(A);
		System.out.println(gap);
	}

}
