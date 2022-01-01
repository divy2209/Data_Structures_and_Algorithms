package HashingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// https://www.interviewbit.com/discussion/p/easy-cpp-sol-straight/47406/
public class Two_out_of_three {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> twoOutOfThree(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c){
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i<a.size(); i++) if(!map.containsKey(a.get(i))) map.put(a.get(i), 1);
		for(int i = 0; i<b.size(); i++) {
			if(!map.containsKey(b.get(i))) map.put(b.get(i), 2);
			else if(map.get(b.get(i))!=2 && map.get(b.get(i))!=-1) {
				arr.add(b.get(i));
				map.put(b.get(i), -1);
			}
		}
		for(int i = 0; i<c.size(); i++) {
			if(!map.containsKey(c.get(i))) map.put(c.get(i), 3);
			else if(map.get(c.get(i))!=3 && map.get(c.get(i))!=-1) {
				arr.add(c.get(i));
				map.put(c.get(i), -1);
			}
		}
		Collections.sort(arr);
		return arr;
	}
	static ArrayList<Integer> input(){
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<Integer> a = input();
		ArrayList<Integer> b = input();
		ArrayList<Integer> c = input();
		scan.close();
		System.out.println(twoOutOfThree(a, b, c));
	}
}
