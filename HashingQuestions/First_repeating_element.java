package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class First_repeating_element {
	static int firstRepeatingElement(ArrayList<Integer> arr) {
		int num = -1, index = Integer.MAX_VALUE;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<arr.size(); i++) {
			if(map.containsKey(arr.get(i))) {
				if(index>map.get(arr.get(i))) {
					index = map.get(arr.get(i));
					num = arr.get(i);
				}
			} else map.put(arr.get(i), i);
		}
		return num;
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(firstRepeatingElement(input()));
	}
}
