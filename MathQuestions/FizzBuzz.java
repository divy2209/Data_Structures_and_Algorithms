package MathQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class FizzBuzz {
	static ArrayList<String> fizzBuzzList(int A){
		ArrayList<String> ans = new ArrayList<String>(A);
		for(int i = 1; i<=A; i++) {
			if(i%3==0 && i%5==0) ans.add("FizzBuzz");
			else if(i%3==0) ans.add("Fizz");
			else if(i%5==0) ans.add("Buzz");
			else ans.add(Integer.toString(i));
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		scan.close();
		System.out.println(fizzBuzzList(A)); 
	}

}
