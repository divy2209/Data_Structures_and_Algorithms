package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://github.com/royalpranjal/Interview-Bit/blob/master/Hashing/PointsOnTheStriaghtLine.cpp
// https://github.com/nagajyothi/InterviewBit/blob/master/Hashing/Points.java
public class Points_on_the_straight_line {
	static Scanner scan = new Scanner(System.in);
	static int maxPointsOnStraightLine(ArrayList<Integer> x, ArrayList<Integer> y) {
		if(x.size()==0 || y.size()==0) return 0;
		HashMap<Double, Integer> map = new HashMap<>();
		int ans = 1;
		for(int i = 0; i<x.size(); i++) {
			int duplicate = 1;
			int vertical = 0;
			int xi = x.get(i);
			int yi = y.get(i);
			for(int j = i+1; j<x.size(); j++) {
				int xj = x.get(j);
				int yj = y.get(j);
				if(xi==xj) {
					if(yi==yj) duplicate++;
					else vertical++;
				} else {
					double slope = 0.0;
					double x1 = xj-xi;
					double y1 = yj-yi;
					if(y1!=0) slope = y1/x1;
					map.put(slope, map.getOrDefault(slope, 0)+1);
				}
			}
			for(Integer count : map.values()) {
				if(count+duplicate>ans) ans = count+duplicate;
			}
			if(vertical+duplicate>ans) ans = vertical+duplicate;
			map.clear();
		}
		return ans;
	}
	static ArrayList<Integer> input(int n){
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		return arr;
	}
	public static void main(String[] args) {
		int n = scan.nextInt();
		ArrayList<Integer> x = input(n);
		ArrayList<Integer> y = input(n);
		scan.close();
		System.out.println(maxPointsOnStraightLine(x, y));
	}
}
