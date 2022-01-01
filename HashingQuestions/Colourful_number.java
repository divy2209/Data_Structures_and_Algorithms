package HashingQuestions;

import java.util.HashMap;
import java.util.Scanner;

// https://github.com/SrGrace/InterviewBit/blob/master/Hashing/ColorfulNumber.cpp
public class Colourful_number {
	static int isColourfulNumber(int n) {
		String str = Integer.toString(n);
		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();
		for(int i = 0; i<str.length(); i++) {
			long num = 1;
			for(int j = i; j<str.length(); j++) {
				num *= (long)(str.charAt(j)-'0');
				if(map.containsKey(num)) return 0;
				map.put(num, true);
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println(isColourfulNumber(n));
	}
}
