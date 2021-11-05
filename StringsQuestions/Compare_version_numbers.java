package StringsQuestions;

import java.util.Scanner;

public class Compare_version_numbers {
	static int compareVersions(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		
		//String[] s1 = version1.split("[.]");
		//String[] s2 = version2.split("[.]");
		
		int n1 = s1.length;
		int n2 = s2.length;
		
		int l = Math.max(n1, n2);
		for(int i = 0; i<l; i++) {
			double v1 = i<n1 ? Double.parseDouble(s1[i]) : 0;
			double v2 = i<n2 ? Double.parseDouble(s2[i]) : 0;
			
			if(v1>v2) return 1;
			else if(v2>v1) return -1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String version1 = scan.next();
		String version2 = scan.next();
		scan.close();
		System.out.println(compareVersions(version1, version2));
	}
}
