package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Max_non_negative_subarray {
	static ArrayList<Integer> maxset(int[] h) {
        int start=0, end=0, sum=0, final_sum = 0, l = 0, fl = 0, fstart = 0, fend = 0;
        for(int i = 0; i<h.length; i++) {
            if(h[i]>=0) {
                sum = sum + h[i];
                end = i;
                l++;
            } else {
                if(sum>final_sum){
                    final_sum = sum;
                    fl = l;
                    fstart = start;
                    fend = end;
                } else if(sum==final_sum) {
                    if(l>fl){
                        fl = l;
                        fstart = start;
                        fend = end;
                    } else if(l==fl){
                        if(start<fstart) {
                            fstart = start;
                            fend = end;
                        }
                    }
                }
                sum = 0;
                start = i+1;
            }
        }
        ArrayList<Integer> B = new ArrayList<Integer>();
        for(int j = fstart; j<=fend && fl!=0; j++) {
            B.add(h[j]);
        }
        return B;
    }
	
	static int[] InputArray() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = InputArray();
		System.out.print(maxset(arr));
	}

}
