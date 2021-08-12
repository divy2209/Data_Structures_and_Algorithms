package ArrayQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Floyd's cycle-finding algorithm
//https://www.youtube.com/watch?v=Aup0kOWoMVg

public class Find_duplicate_in_array {
	static int repeatedNumber(final List<Integer> A) {
		int slow = A.get(0), fast = A.get(A.get(0));
        while(slow!=fast){
            slow = A.get(slow);
            fast = A.get(A.get(fast));
        }
        fast = 0;
        while(slow!=fast){
            slow = A.get(slow);
            fast = A.get(fast);
        }
        return slow;
	}
	static List<Integer> input(){
		// length = n+1
		// all elements in between [1,n]
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> A = new LinkedList<Integer>();;
		for(int i = 0; i<n; i++) {
			A.add(scan.nextInt());
		}
		scan.close();
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = input();
		int num = repeatedNumber(A);
		System.out.println(num);
	}

}
