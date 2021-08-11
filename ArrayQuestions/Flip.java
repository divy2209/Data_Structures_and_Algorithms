package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Flip {
	static ArrayList<Integer> flip(String A){
		int count = 0, fcount = 0, l = 0, r = 0, ltemp = 0;
        for(int i = 0; i<A.length(); i++){
            int ch = Integer.parseInt(String.valueOf(A.charAt(i)));
            if(ch == 0){
                count++;
            } else{
                count--;
            }
            if(count>fcount){
                fcount = count;
                r = i;
                l = ltemp;
            }
            if(count<0){
                count = 0;
                ltemp = i+1;
            }
        }
        ArrayList<Integer> B = new ArrayList<Integer>();
        if(fcount>0){
            B.add(l+1);
            B.add(r+1);
        }
        
        return B;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		scan.close();
		ArrayList<Integer> B = flip(A);
		System.out.println(B);
	}

}
