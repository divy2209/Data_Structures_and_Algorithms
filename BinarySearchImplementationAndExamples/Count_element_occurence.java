package BinarySearchImplementationAndExamples;

import java.util.ArrayList;
import java.util.Scanner;

public class Count_element_occurence {
	static Scanner scan = new Scanner(System.in);
	
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	
	static int frequency(ArrayList<Integer> A, int B) {
		int n = A.size();
        int low = 0;
        int high = n-1;
        int start = -1;
        int end = -1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if((mid==0 || B>A.get(mid-1)) && A.get(mid)==B){
                start = mid;
                break;
            }
         // shifting the low from the left and if B & A.get is equal, we'll shift the high cause we want to find the start
            else if(B>A.get(mid)) low = mid+1;
            else high = mid-1;
        }
        if(start==-1) return 0;
        low = start;
        high = n-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid==n-1 || B<A.get(mid+1)) && A.get(mid)==B) {
                end = mid;
                break;
            }
            // shifting the high from the right and if B & A.get is equal, we'll shift the low cause we want to find the end
            else if(B<A.get(mid)) high = mid-1;
            else low = mid+1;
        }

        return end-start+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = input();
		int B = scan.nextInt();
		scan.close();
		System.out.println(frequency(A, B));
	}

}
