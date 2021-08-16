package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class First_missing_integer {
	static int firstMissingInteger(ArrayList<Integer> A) {
		int n = A.size();
		for(int i = 0; i<n; i++) {
			if(A.get(i)>0&&A.get(i)<=n) {
				if(A.get(A.get(i)-1) != A.get(i)) {
					int temp = A.get(A.get(i)-1);
					A.set(A.get(i)-1, A.get(i));
					A.set(i, temp);
					i--;
				}
			}
		}
		for(int i = 0; i<n; i++) {
			if(A.get(i)!=i+1) return i+1;
		}
		return n+1;
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
		int num = firstMissingInteger(A);
		System.out.println(num);
	}

}
