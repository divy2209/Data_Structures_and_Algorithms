package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

class Interval {
	int start;
	int end;
	Interval(int s, int e) {
		start = s;
		end = e;
	}
	Interval() {
		start = 0;
		end = 0;
	}
}

public class Merge_intervals {
	static Scanner scan = new Scanner(System.in);
	
	static ArrayList<Interval> merge(ArrayList<Interval> intervals, Interval newInterval){
		int i = 0;
        while(i<intervals.size()){
            Interval current = intervals.get(i);
            if(current.end < newInterval.start){
                i++;
                continue;
            } else if(newInterval.end < current.start){
                intervals.add(i, newInterval);
                break;
            } else {
                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(newInterval.end, current.end);
                intervals.remove(i);
            }
        }
        if(i == intervals.size()){
            intervals.add(newInterval);
        }
        return intervals;
	}
	
	static ArrayList<Interval> Input() {
		int n = scan.nextInt();
		ArrayList<Interval> arr = new ArrayList<Interval>();
		for(int i = 0; i<n; i++) {
			Interval interval = new Interval();
			interval.start = scan.nextInt();
			interval.end = scan.nextInt();
			arr.add(interval);
		}
		return arr;
	}
	
	static void print(ArrayList<Interval> intervals) {
		int n = intervals.size();
		for(int i = 0; i<n; i++) {
			System.out.println("[" + intervals.get(i).start + "," + intervals.get(i).end + "]");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = Input();
		System.out.println("merge interval");
		
		Interval newInterval = new Interval();
		newInterval.start = scan.nextInt();
		newInterval.end = scan.nextInt();
		
		intervals = merge(intervals, newInterval);
		scan.close();
		
		print(intervals);
	}

}
