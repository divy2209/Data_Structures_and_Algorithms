package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.youtube.com/watch?v=T3C7g8NohKw

public class Triplets_with_sum_between_given_range {
	static boolean isina(double x){
        if(x>0 && x<2.0/3.0){
            return true;
        }
        return false;
    }
    static boolean isinb(double x){
        if(x>=2.0/3.0 && x<1.0){
            return true;
        }
        return false;
    }
    static boolean isinc(double x){
        if(x>=1.0 && x<2.0){
            return true;
        }
        return false;
    }
    
    static int check(ArrayList<String> A) {
    	ArrayList<Double> B = new ArrayList<Double>(A.size());
        for(int i = 0; i<A.size(); i++){
            B.add(Double.parseDouble(A.get(i)));
        }
        double max1a = Integer.MIN_VALUE, max2a = Integer.MIN_VALUE, max3a = Integer.MIN_VALUE, max1b = Integer.MIN_VALUE;
        double min1a = Integer.MAX_VALUE, min2a = Integer.MAX_VALUE, min1b = Integer.MAX_VALUE, min2b = Integer.MAX_VALUE, min1c = Integer.MAX_VALUE;
        for(int i = 0; i<B.size(); i++){
            if(max1a<B.get(i) && isina(B.get(i))){
                max3a = max2a;
                max2a = max1a;
                max1a = B.get(i);
                
            } else if(max2a<B.get(i) && isina(B.get(i))){
                max3a = max2a;
                max2a = B.get(i);
            } else if(max3a<B.get(i) && isina(B.get(i))){
                max3a = B.get(i);
            } else if(max1b<B.get(i) && isinb(B.get(i))){
                max1b = B.get(i);
            }
            if(min1a>B.get(i) && isina(B.get(i))){
                min2a = min1a;
                min1a = B.get(i);
            } else if(min2a>B.get(i) && isina(B.get(i))){
                min2a = B.get(i);
            } else if(min1b>B.get(i) && isinb(B.get(i))){
                min2b = min1b;
                min1b = B.get(i);
            } else if(min2b>B.get(i) && isinb(B.get(i))){
                min2b = B.get(i);
            } else if(min1c>B.get(i) && isinc(B.get(i))){
                min1c = B.get(i);
            }
        }
        if(max1a+max2a+max3a>1.0){
            return 1;
        } else if(max1a+max2a+max1b>1.0 && max1a+max2a+max1b<2.0){
            return 1;
        } else if(min1a+min2a+min1b>1.0 && min1a+min2a+min1b<2.0){
            return 1;
        } else if(min1a+min2a+min1c<2.0){
            return 1;
        } else if(min1a+min1b+min1c<2.0){
            return 1;
        } else if(min1a+min1b+min2b<2.0){
            return 1;
        }
        return 0;
    }
    
    static ArrayList<String> Input() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.next());
		}
		scan.close();
		return arr;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> A = Input();
		int value = check(A);
		System.out.println(value);
	}

}
