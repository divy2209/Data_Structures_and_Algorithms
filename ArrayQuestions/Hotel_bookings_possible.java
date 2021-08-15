package ArrayQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hotel_bookings_possible {
	static Scanner scan = new Scanner(System.in);
	static boolean bookingPossible(ArrayList<Integer> arrive, ArrayList<Integer> depart, int rooms) {
		Collections.sort(arrive);
		Collections.sort(depart);
		int n = arrive.size();
		ArrayList<Integer> counter = new ArrayList<Integer>(2*n);
		int i = 0, j = 0;
		while(i<n && j<n) {
			if(arrive.get(i)<depart.get(j)) {
				counter.add(-1);
				i++;
			} else {
				counter.add(1);
				j++;
			}
		}
		while(i<n) {
			counter.add(-1);
			i++;
		}
		while(j<n) {
			counter.add(1);
			j++;
		}
		int count = rooms;
		for(int t = 0; t<2*n; t++) {
			count+=counter.get(t);
			if(count<0) return false;
		}
		return true;
	}
	
	static ArrayList<Integer> Input() {
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrive = Input();
		ArrayList<Integer> depart = Input();
		int rooms = scan.nextInt();
		scan.close();
		boolean possible = bookingPossible(arrive, depart, rooms);
		System.out.println(possible);
	}

}
