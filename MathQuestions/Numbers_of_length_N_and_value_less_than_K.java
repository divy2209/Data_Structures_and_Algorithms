package MathQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=MT8zeLak_bI
public class Numbers_of_length_N_and_value_less_than_K {
	static Scanner scan = new Scanner(System.in);
	
	static int numberOfPossibleNumbers(ArrayList<Integer> A, int B, int C) {
		int n = A.size();
		int len = Integer.toString(C).length();
		int ans = 0;
		if(n==0) return ans;
		else if(B>len) return ans;
		else if(B<len) {
			if(A.get(0)==0) {
				ans = (n-1)*(int)Math.pow(n, B-1);
				if(B==1) ans++;
			} else {
				ans = (int)Math.pow(n, B);
			}
		} else if(B==len) {
			if(B==1) {
				for(int i = 0; i<n; i++) {
					if(A.get(i)<C) ans++;
				}
			} else {
				int[] num = new int[len];
				for(int i = len-1; i>=0; i--) {
					num[i] = C%10;
					C/=10;
				}
				int count = 0;
				int flag = 0, j = 0;
				for(int i = 0; i<n; i++) {
					if(A.get(i)==num[j]) flag = 1;
					
					if(A.get(i)==0) continue;
					else if(A.get(i)>num[0]) break;
					else count++;
				}
				ans = count*(int)Math.pow(n, B-1);
				// contains some additional cases which we will next remove
				j++;
				while(flag==1&&j<B) {
					flag = 0;
					int countx = 0;
					for(int i = 0; i<n; i++) {
						if(A.get(i)==num[j]) flag = 1;
						else if(A.get(i)>num[j]) countx++;
					}
					ans-=countx*(int)Math.pow(n, B-j-1);
					j++;
				}
				if(flag==1 && j==B) ans--;
			}
		}
		return ans;
	}
	
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			a.add(scan.nextInt());
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = input();
		int B = scan.nextInt();
		int C = scan.nextInt();
		scan.close();
		System.out.println(numberOfPossibleNumbers(A, B, C));
	}

}
