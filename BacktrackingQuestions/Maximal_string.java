package BacktrackingQuestions;

import java.util.Scanner;

// https://www.interviewbit.com/discussion/p/simple-c-soln-using-backtracking/43329/
// https://www.youtube.com/watch?v=7rRibptKjus
// In the above video, the final code does not consider the atmost swap part
public class Maximal_string {
	static String ans = "";
	static void find(char[] ch, int b) {
		if(b==0) {
			//if(ans.compareTo(new String(ch))<0) ans=new String(ch);
			return;
		}
		int n = ch.length;
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				if(ch[j]>ch[i]) {
					swap(ch, i, j);
					if((new String(ch)).compareTo(ans)>0) ans = new String(ch);
					find(ch, b-1);
					swap(ch, i, j);
				}
			}
		}
		
	}
	static void swap(char[] ch, int i, int j) {
		char c = ch[i];
		ch[i] = ch[j];
		ch[j] = c;
	}
	static String lexilogicallyMaximalString(String str, int b) {
		ans = "";
		char[] ch = str.toCharArray();
		find(ch, b);
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int b = scan.nextInt();
		scan.close();
		System.out.println(lexilogicallyMaximalString(str, b));
	}
}
