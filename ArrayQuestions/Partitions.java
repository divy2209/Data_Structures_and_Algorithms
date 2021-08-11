package ArrayQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Partitions {
	static Scanner scan = new Scanner(System.in);
	
	static int partitionCount(int A, ArrayList<Integer> B) {
		int arrSum = 0;
        for(int i = 0; i<A; i++) {
            arrSum = arrSum + B.get(i);
        }
        if(arrSum%3==0){
            int onethird = arrSum/3;
            int tempsum = 0;
            ArrayList<Integer> temp = new ArrayList<Integer>(Collections.nCopies(A, 0));
            for(int i = A-1; i>=0; i--){
                tempsum += B.get(i);
                if(tempsum == onethird){
                    temp.set(i, 1);
                }
            }
            tempsum = 0;
            int count = 0;
            for(int i = 0; i<A; i++){
                tempsum += B.get(i);
                if(tempsum == onethird) {
                    for(int j = i+2; j<A; j++){
                        if(temp.get(j)==1){
                            count++;
                        }
                    }
                }
            }
            return count;
        } else {
            return 0;
        }
	}
	
	static ArrayList<Integer> Input(int A) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<A; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = scan.nextInt();
		ArrayList<Integer> B = Input(A);
		int count = partitionCount(A, B);
		scan.close();
		System.out.println(count);
		
	}

}
