package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=KOD2BFauQbA
public class Gray_code {
	static ArrayList<Integer> grayCode(int n){
		ArrayList<String> arr = generateGrayCode(n);
		System.out.println(arr);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i<arr.size(); i++) {
			// temp converting the bit string into number of base 2
			int temp = Integer.parseInt(arr.get(i), 2);
			ans.add(temp);
		}
		return ans;
	}
	static ArrayList<String> generateGrayCode(int n){
		if(n==1) {
			ArrayList<String> arr = new ArrayList<String>();
			arr.add("0");
			arr.add("1");
			return arr;
		}
		ArrayList<String> arr = generateGrayCode(n-1);
		ArrayList<String> ans = new ArrayList<String>();
		for(int i = 0; i<arr.size(); i++) {
			ans.add("0"+arr.get(i));
		}
		for(int i = arr.size()-1; i>=0; i--) {
			ans.add("1" + arr.get(i));
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(grayCode(n));
	}
}
