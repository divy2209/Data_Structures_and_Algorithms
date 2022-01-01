package HashingQuestions;

import java.util.HashMap;
import java.util.Scanner;
// https://www.youtube.com/watch?v=e1HlptlipB0
public class Window_string {
	static String windowString(String s, String t) {
		int ls = s.length(), lt = t.length();
		if(lt>ls) return "";
		HashMap<Character, Integer> toFind = new HashMap<>();
		HashMap<Character, Integer> map = new HashMap<>();
		String ans = "";
		for(int i = 0; i<lt; i++) {
			//if(toFind.containsKey(t.charAt(i))) toFind.put(t.charAt(i), map.get(t.charAt(i))+1);
			//else toFind.put(t.charAt(i), 1);
			toFind.put(t.charAt(i), toFind.getOrDefault(t.charAt(i), 0)+1);
		}
		int i = 0, j = 0, matching = 0;
		int start = 0, end = Integer.MAX_VALUE;
		while(i<ls) {
			if(matching<lt && j<ls) {
				//if(map.containsKey(s.charAt(j))) map.put(s.charAt(j), map.get(s.charAt(j))+1);
				//else map.put(s.charAt(j), 1);
				map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
				
				if(toFind.containsKey(s.charAt(j)) && map.get(s.charAt(j))<=toFind.get(s.charAt(j))) matching++;
				j++;
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i))-1);
				if(toFind.containsKey(s.charAt(i)) && map.get(s.charAt(i))<toFind.get(s.charAt(i))) matching--;
				i++;
			}
			
			if(matching==lt && (j-i<end-start || (/*j-i==end-start && */i<start))) {
				ans = s.substring(i, j);
			} else if(j>=ls) break;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		String t = scan.next();
		scan.close();
		System.out.println(windowString(s, t));
	}
}
