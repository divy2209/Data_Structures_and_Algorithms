package BitManipulationQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=_vSi_Wasm84
public class Single_integer_2 {
	static int onceAppearingNum(ArrayList<Integer> arr) {
		int n = arr.size();
		int ans = 0;
		for(int i = 0; i<32; i++) {
			int count = 0;
			for(int j = 0; j<n; j++) {
				if((arr.get(j)>>i&1)==1) count++;
				//if((arr.get(j)&1<<i)==1) count++;
			}
			if(count%3!=0) ans|=(1<<i);
		}
		return ans;
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(onceAppearingNum(input()));
	}
}
