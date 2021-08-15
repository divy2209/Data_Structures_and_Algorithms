package ArrayQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Largest_number {
	static String largestNum(final List<Integer> A) {
		int n = A.size();
		if(n==0) return "";
		String[] arr = new String[n];
		int zeroes = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.toString(A.get(i));
			if(A.get(i)==0) zeroes++;
		}
		if(zeroes==n) return "0";
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String a, String b) {
				String o1 = a+b;
				String o2 = b+a;
				return o2.compareTo(o1);
			}
		});
		String ans = "";
		for(int i = 0; i<n; i++) {
			ans+=arr[i];
		}
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
		String num = largestNum(A);
		System.out.println(num);
	}

}
