package TwoPointersQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=cPJeRP6CaIY
public class Counting_triangles {
	static int countTriangles(ArrayList<Integer> arr) {
		int n = arr.size();
		Collections.sort(arr);
		long mod = 1000000007;
		long count = 0;
		for(int k = n-1; k>=2; k--) {
			int i = 0, j = k-1;
			while(i<j) {
				int t = arr.get(i)+arr.get(j);
				if(t>arr.get(k)) {
					count+=j-i;
					count%=mod;
					j--;
				} else {
					i++;
				}
			}
		}
		return (int)count;
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
		System.out.println(countTriangles(input()));
	}
}
