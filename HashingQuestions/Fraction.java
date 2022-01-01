package HashingQuestions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.youtube.com/watch?v=2cRS9dNa780
public class Fraction {
	static String fraction(int numerator, int denominator) {
		if(numerator==0) return "0";
		StringBuilder ans = new StringBuilder();
		if((numerator<0 && denominator>0) || (numerator>0 && denominator<0)) ans.append('-');
		long n = numerator>0 ? (long)numerator : (-1)*(long)numerator;
		long d = denominator>0 ? (long)denominator : (-1)*(long)denominator;
		ans.append(n/d);
		long r = n%d;
		if(r==0) return ans.toString();
		// LinkedHashMap preserves the input order
		LinkedHashMap<Long, Long> map = new LinkedHashMap<>();
		ans.append('.');
		while(r!=0) {
			r*=10;
			if(!map.containsKey(r)) {
				map.put(r, r/d);
				r%=d;
			} else break;
		}
		if(r==0) {
			for(Long val : map.values()) ans.append(val);
		} else {
			for(Map.Entry<Long, Long> entry : map.entrySet()) {
				if(entry.getKey()==r) ans.append('(');
				ans.append(entry.getValue());
			}
			ans.append(')');
		}
		return ans.toString();
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numerator = scan.nextInt();
		int denominator = scan.nextInt();
		scan.close();
		System.out.println(fraction(numerator, denominator));
	}
}
