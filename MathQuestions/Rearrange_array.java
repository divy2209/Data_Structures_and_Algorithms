package MathQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Rearrange_array {
	static void rearrange(ArrayList<Integer> a) {
		int n = a.size();
		for(int i = 0; i<n; i++) {
			int temp = a.get(i);
			a.set(i,  (a.get(temp)%n)*n+temp);
		}
		for(int i = 0; i<n; i++) {
			a.set(i,  a.get(i)/5);
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
		ArrayList<Integer> a = Input();
		rearrange(a);
		System.out.println(a);
	}

}
