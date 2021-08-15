package ArrayQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wave_array {
	static void waveSort(ArrayList<Integer> A) {
		Collections.sort(A);
		int n = A.size();
		if(n%2!=0) n--;
		int i = 0;
		while(i<n) {
			int temp = A.get(i);
			A.set(i,  A.get(i+1));
			A.set(i+1, temp);
			i+=2;
		}
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
		waveSort(A);
		System.out.println(A);
	}

}
