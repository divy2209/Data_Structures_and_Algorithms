package MathQuestions;

import java.util.Scanner;

// https://www.youtube.com/watch?v=WJAA6jr8hMM
public class Step_by_step_reach_a_number {
	static int steps(int A) {
		int target = Math.abs(A);
        if(target==0) return 0;
        int count = 0;
        int num = 0;
        while(num<target){
            num+=count;
            count++;
        }
        // Just crossed the target
        while((num-target)%2==1){
        	// now we have to substract a number divisible by 2 from the sum to reach target, so sum-target should be divisible by 2, add steps until that happens keep counting steps
            num+=count;
            count++;
        }
        return count-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		System.out.println(steps(A));
	}

}
