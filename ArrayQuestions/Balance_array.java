package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Balance_array {
	static int balanceCount(ArrayList<Integer> A) {
		int esum = 0, osum = 0;
        for(int i = 0; i<A.size(); i++){
            if(i%2==0){
                esum+=A.get(i);
            } else {
                osum+=A.get(i);
            }
        }
        int wesum = 0, wosum = 0, count = 0;
        for(int i = 0; i<A.size(); i++){
            int even = 0, odd = 0;
            if(i%2==0){
                even = wesum + osum - wosum;
                odd = wosum + esum - wesum - A.get(i);
            } else {
                even = wesum + osum - wosum - A.get(i);
                odd = wosum + esum - wesum;
            }
            if(even==odd){
                count++;
            }
            if(i%2==0){
                wesum+=A.get(i);
            } else {
                wosum+=A.get(i);
            }
        }
        return count;
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
		int count = balanceCount(A);
		System.out.println(count);
	}

}
