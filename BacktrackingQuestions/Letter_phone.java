package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=-vKub-ZC0cY
public class Letter_phone {
	static ArrayList<String> letterPhone(String str){
		ArrayList<String> arr = new ArrayList<String>(10);
		arr.add("0");
		arr.add("1");
		arr.add("abc");
		arr.add("def");
		arr.add("ghi");
		arr.add("jkl");
		arr.add("mno");
		arr.add("pqrs");
		arr.add("tuv");
		arr.add("wxyz");
		ArrayList<String> ans = new ArrayList<String>();
		generateLetterPhone(ans, arr, str, "", 0);
		return ans;
	}
	static void generateLetterPhone(ArrayList<String> ans, ArrayList<String> arr, String str, String temp, int index) {
		if(index==str.length()) {
			ans.add(temp);
			return;
		}
		int num = Integer.parseInt(Character.toString(str.charAt(index)));
		for(int i = 0; i<arr.get(num).length(); i++) {
			// here, it is index+1 because we have to traverse through the str string using the recursion and traverse through the arr using loop
			generateLetterPhone(ans, arr, str, temp+arr.get(num).charAt(i), index+1);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(letterPhone(str));
	}
}
