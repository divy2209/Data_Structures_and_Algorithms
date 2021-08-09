package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Add_one_to_number {
	static ArrayList<Integer> addOne(ArrayList<Integer> A) {
		ArrayList<Integer> B = new ArrayList<Integer>();
        for(int j = 0; j<A.size(); j++){
            if(A.get(j)==0 && B.size()==0){
                continue;
            }
            B.add(A.get(j));
        }
        if(B.size() == 0){
            B.add(0);
        }
        int n = B.size();
        B.set(n-1, B.get(n-1)+1);
        int carry = B.get(n-1)/10;
        B.set(n-1, B.get(n-1)%10);

        for(int i = n-2; i>=0; i--){
            if(carry==1){
                B.set(i, B.get(i)+1);
                carry = B.get(i)/10;
                B.set(i, B.get(i)%10);
            }
        }

        if(carry == 1){
            B.add(0, 1);
        }

        return B;
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
	
	static void printArray(ArrayList<Integer> arr) {
		for(int e = 0; e<arr.size(); e++) {
			System.out.print(arr.get(e));
			System.out.print(' ');
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = Input();
		ArrayList<Integer> arr = addOne(A);
		printArray(arr);
		
	}

}
