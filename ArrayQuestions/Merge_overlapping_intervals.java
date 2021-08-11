package ArrayQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Merge_overlapping_intervals {
	// Interval class already defined in merge_intervals
	static ArrayList<Interval> sort(ArrayList<Interval> intervals){
        ArrayList<Interval> sortedIntervals = new ArrayList<Interval>();
        Interval min = new Interval();
        int r = 0, k = 0;
        while(intervals.size()>0){
            Interval fmin = new Interval(Integer.MAX_VALUE, 0);
            for(int j = 0; j<intervals.size(); j++){
                min = intervals.get(j);
                if(min.start<fmin.start){
                    fmin = min;
                    r = j;
                }
            }
            intervals.remove(r);
            sortedIntervals.add(k, fmin);
            k++;
        }
        return sortedIntervals;
    }
	
	static ArrayList<Interval> merge(ArrayList<Interval> intervals){
		int i = 0;
        intervals = sort(intervals);
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        while(i<intervals.size()){
            Interval interval = intervals.get(i);
            if(end<interval.start){
                start = interval.start;
                end = interval.end;
                i++;
                continue;
            } else {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
                intervals.remove(i);
                intervals.remove(i-1);
                Interval newi = new Interval(start, end);
                intervals.add(i-1, newi);
            }
        }
        return intervals;
	}
	
	static ArrayList<Interval> Input() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Interval> arr = new ArrayList<Interval>();
		for(int i = 0; i<n; i++) {
			Interval interval = new Interval();
			interval.start = scan.nextInt();
			interval.end = scan.nextInt();
			arr.add(interval);
		}
		scan.close();
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
		
		intervals = merge(intervals);
		
		print(intervals);
	}

}
