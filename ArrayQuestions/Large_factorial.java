package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Large_factorial {
	public static String factorial(int A) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String rev = "";
        arr.add(1);
        int index = 1;

        for(int i = 1; i<=A; i++){
            index = multiply(arr, i, index);
        }
        for(int j = index-1; j>=0; j--){
            rev = rev + Integer.toString(arr.get(j));
        }
        return rev;
    }
	
    static int multiply(ArrayList<Integer> arr, int x, int index){
        int carry = 0;
        int pro = 1;
        for(int i = 0; i<index; i++){
            pro = arr.get(i);
            pro = pro*x+carry;
            arr.set(i, pro%10);
            carry = pro/10;
        }
        while(carry!=0){
            arr.add(carry%10);
            carry = carry/10;
            index++;
        }
        return index;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String factorial = factorial(n);
		scan.close();
		System.out.println(factorial);
	}

}
