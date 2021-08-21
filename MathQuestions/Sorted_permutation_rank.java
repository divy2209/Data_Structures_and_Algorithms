package MathQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class Sorted_permutation_rank {
	static int rank(String A) {
		int len = A.length();
        int n = len-1;
        int rank = 1;
        char[] str = new char[len];
        int[] check = new int[len];
        for(int i = 0; i<len; i++){
            str[i] = A.charAt(i);
            check[i] = 1;
        }
        Arrays.sort(str);
        for(int i = 0; i<len; i++){
            char temp = A.charAt(i);
            int count = 0;
            for(int j = 0; j<len; j++){
                if(temp==str[j]){
                    check[j]=0;
                    rank = (rank + count*factorial(n))%1000003;
                    n--;
                    break;
                }
                count+=check[j];
            }
        }
        return rank;
	}
	
	static int factorial(int n) {
		int fact = 1;
        for(int i = 2; i<=n; i++){
            fact = (fact*i)%1000003;
        }
        return fact;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		System.out.println(rank(str));
		scan.close();
	}

}
