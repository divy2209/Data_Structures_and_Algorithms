package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Max_continuous_series_of_1s {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> maxContinuousSeriesList(ArrayList<Integer> arr, int b){
		int n = arr.size();
		int i = 0, j = 0, ans = 0, flip = 0;
		int start = 0, end = 0;
		while(i<n) {
			if(arr.get(i)==0) flip++;
			while(flip>b) {
				if(arr.get(j)==0) flip--;
				j++;
			}
			if(i-j+1>ans) {
				ans = Math.max(ans, i-j+1);
				start = j;
				end = i;
			}
			i++;
		}
		ArrayList<Integer> a = new ArrayList<Integer>(end-start+1);
		while(start<=end) {
			a.add(start);
			start++;
		}
		return a;
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
		System.out.println(maxContinuousSeriesList(input(), scan.nextInt()));
		scan.close();
	}
}
