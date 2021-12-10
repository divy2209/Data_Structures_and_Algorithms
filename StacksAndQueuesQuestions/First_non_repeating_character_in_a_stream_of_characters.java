package StacksAndQueuesQuestions;

import java.util.*;

// https://www.youtube.com/watch?v=4kqz5e9kIuQ
public class First_non_repeating_character_in_a_stream_of_characters {
	static String firstNonRepeatingCharacter(String str) {
		// Time complexity will fail, if we have to build a long string without stringbuilder or char array to new string
		int l = str.length();
		Queue<Character> q = new LinkedList<Character>();
		ArrayList<Integer> arr = new ArrayList<Integer>(Collections.nCopies(26, 0));
		//String result = "";
		char[] ans = new char[l];
		for(int i = 0; i<l; i++) {
			char c = str.charAt(i);
			int j = c-'a';
			arr.set(j, arr.get(j)+1);
			if(arr.get(j)<2) q.add(c);
			while(!q.isEmpty() && arr.get(q.peek()-'a')>1) q.poll();
			//if(!q.isEmpty()) result+=Character.toString(q.peek());
			// here, we can add a char directly to a string, no issues with that
			//else result+="#";
			if(!q.isEmpty()) ans[i] = q.peek();
			else ans[i] = '#';
		}
		//return result;
		return new String(ans);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		scan.close();
		System.out.println(firstNonRepeatingCharacter(str));
	}
}
