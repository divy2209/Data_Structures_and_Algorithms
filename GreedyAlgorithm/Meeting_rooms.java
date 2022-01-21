package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://github.com/black-shadows/InterviewBit-Topicwise-Solutions/blob/master/Heaps%20and%20Maps/Meeting%20rooms.cpp
// https://www.youtube.com/watch?v=KIKjKlbJUwU
public class Meeting_rooms {
	static int meetingRoomsSpaceApproach(ArrayList<ArrayList<Integer>> arr) {
		// This is an approach is in O(n) but once the set is increased, the invisible multiplier with n gets visible and time consuming
		Collections.sort(arr,(a,b)->a.get(0)-b.get(0));
		ArrayList<Integer> rooms = new ArrayList<>();
		for(int i = 0; i<arr.size(); i++) {
			int e = arr.get(i).get(0);
			boolean check = false;
			for(int j = 0; j<rooms.size(); j++) {
				if(e>=rooms.get(j)) {
					rooms.set(j, arr.get(i).get(1));
					check = true;
					break;
				}
			}
			if(!check) rooms.add(arr.get(i).get(1));
		}
		return rooms.size();
	}
	static int meetingRoomsOptimumApproach(ArrayList<ArrayList<Integer>> arr) {
		// This is an efficient approach, with O(nlogn) time complexity without any multiplier
		int n = arr.size();
		ArrayList<Integer> start = new ArrayList<>(n);
		ArrayList<Integer> end = new ArrayList<>(n);
		for(int i = 0; i<n; i++) {
			start.add(arr.get(i).get(0));
			end.add(arr.get(i).get(1));
		}
		Collections.sort(start);
		Collections.sort(end);
		int i = 0, j = 0, res = 0;
		while(i<n) {
			if(start.get(i)<end.get(j)) i++;
			else if(start.get(i)>end.get(j)) j++;
			else {
				i++;
				j++;
			}
			res = Math.max(res, i-j);
		}
		return res;
	}
	static ArrayList<ArrayList<Integer>> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
		for(int i = 0; i<n; i++) {
			ArrayList<Integer> temp = new ArrayList<>(2);
			temp.add(scan.nextInt());
			temp.add(scan.nextInt());
			arr.add(temp);
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = input();
		System.out.println(meetingRoomsSpaceApproach(arr));
		System.out.println(meetingRoomsOptimumApproach(arr));
	}
}
