package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;


// Moore-voting algorithm
public class Nby3_repeat_number {
	static int nby3_RepeatNumber(ArrayList<Integer> A) {
		int n = A.size();
		int count1 = 0, count2 = 0, ele1 = Integer.MAX_VALUE, ele2 = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			if(ele1==A.get(i)) count1++;
			else if(ele2==A.get(i)) count2++;
			else if(count1==0) {
				count1++;
				ele1=A.get(i);
			} else if(count2==0) {
				count2++;
				ele2=A.get(i);
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for(int i = 0; i<n; i++) {
			if(ele1==A.get(i)) count1++;
			else if(ele2==A.get(i)) count2++;
		}
		if(count1>n/3) return ele1;
		if(count2>n/3) return ele2;
		return -1;
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
		int num = nby3_RepeatNumber(A);
		System.out.println(num);
	}

}
