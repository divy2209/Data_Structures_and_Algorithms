package StringsQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class pretty_json {
	static ArrayList<String> justifiedText(String json) {
		int n = json.length();
		ArrayList<String> ans = new ArrayList<String>();
		int t = 0;
		String s = "";
		
		for(int i = 0; i<n; i++) {
			if(json.charAt(i)=='{' || json.charAt(i)=='[') {
				ans.add(s);
				s="";
				for(int j = 0; j<t; j++) s+="\t";
				s+=Character.toString(json.charAt(i));
				ans.add(s);
				s="";
				t++;
				for(int j = 0; j<t; j++) s+="\t";
			} else if(json.charAt(i)=='}' || json.charAt(i)==']') {
				ans.add(s);
				s="";
				t--;
				for(int j = 0; j<t; j++) s+="\t";
				s+=Character.toString(json.charAt(i));
				if(i+1<n && json.charAt(i+1)==',') {
					s+=Character.toString(json.charAt(i+1));
					i++;
				}
				ans.add(s);
				s="";
				for(int j = 0; j<t; j++) s+="\t";
			} else if(json.charAt(i)==',') {
				s+=Character.toString(json.charAt(i));
				ans.add(s);
				s="";
				for(int j = 0; j<t; j++) s+="\t";
			} else s+=Character.toString(json.charAt(i));
		}
		ans.add(s);
		boolean flag;
		for(int i = 0; i<ans.size(); i++) {
			flag = true;
			for(int j = 0; j<ans.get(i).length(); j++) {
				if(ans.get(i).charAt(j)!='\t' && ans.get(i).charAt(j)!=' ') {
					flag = false;
					break;
				}
			}
			if(flag) {
				ans.remove(i);
				i--;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String json = scan.nextLine();
		scan.close();
		ArrayList<String> ans = justifiedText(json);
		for(int i = 0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}
