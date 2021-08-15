package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Minimum_lights_to_activate {
	static Scanner scan = new Scanner(System.in);
	static int solve(ArrayList<Integer> A, int B) {
		//int start = 0;
	    int count = 0;
	    
	    
	    
	    for(int i=0; i< A.size();){
	        
	        // we start observing from left to right in the array
	        // Find the left most possible place which can be li by the light at position i
	        // siminarly find he rightmost place which can be lit by light at this place i
	        //start = i+1-B  <  0?0 : i+1-B;
	        int right = i-1+B > A.size()-1 ? A.size()-1 : i-1+B;
	        
	        
	        // we are greedily trying to find the right-most position possible where a light 
	        // can be activated such that the position i can also be lit.
	        // rightmost guarantees the optimal value proved by greedy approach.
	        while(right >=0 && right >= i-B+1 && A.get(right) == 0){
	            right--;
	        }
	        
	        
	        // if we find no light which can light the current position we return -1.
	        if(right < 0 || right < i-B+1){
	            return -1;
	        }
	        
	        // indicates we have allocated a light.
	            count++;
	        
	        // After the position at 'right' is lit, we don't necessarily need to check from 
	        // 'right+1', instead we can directly hop to 'B' places after this position
	        // because once light is lit at one place the nex 'B-1' places will 
	        // atuomatically be lit.
	        i += (right + B  - i);
	    }
	    return count;
	}
	
	static ArrayList<Integer> Input(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scan.nextInt();
		ArrayList<Integer> A = Input(n);
		System.out.println("Bulb power");
		int B = scan.nextInt();
		
		int count = solve(A, B);
		System.out.println(count);
	}

}
