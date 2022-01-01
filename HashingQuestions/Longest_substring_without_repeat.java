package HashingQuestions;

import java.util.HashMap;
import java.util.Scanner;

// https://www.youtube.com/watch?v=9Kc0eZBGL1U
public class Longest_substring_without_repeat {
	static int longestSubstringWithoutRepeat(String str) {
		int count = 0, i = 0, j = 0, ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while(i<str.length() && j<str.length()) {
			if(!map.containsKey(str.charAt(j))) {
				map.put(str.charAt(j), 1);
				count++;
				j++;
			} else {
				map.remove(str.charAt(i));
				count--;
				i++;
			}
			ans = ans>count ? ans : count;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(longestSubstringWithoutRepeat(str));
	}
}
