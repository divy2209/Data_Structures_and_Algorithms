package DynamicProgrammingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.youtube.com/watch?v=VwylCVAVdmo
// https://www.geeksforgeeks.org/partition-an-array-of-non-negative-integers-into-two-subsets-such-that-average-of-both-the-subsets-is-equal/
public class Equal_average_partition {
	static ArrayList<Integer> res1;
	static boolean[][][] memo;
	static ArrayList<ArrayList<Integer>> equalAveragePartition(ArrayList<Integer> arr){
		int n = arr.size();
		int sum = 0;
		for(int i = 0; i<n; i++) sum+=arr.get(i);
		Collections.sort(arr);
		
		res1 = new ArrayList<>();
		memo = new boolean[n][sum+1][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<=sum; j++) {
				for(int k = 0; k<n; k++) {
					memo[i][j][k] = true;
				}
			}
		}
		for(int i = 1; i<=n/2; i++) {
			int s = sum*i;
			if(s%n!=0) continue;
			s/=n;
			//if(check(arr, s, i, 0)) break;
			if(checkMemo(arr, s, i, 0)) break;
			res1.clear();
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int k = res1.size();
		if(k!=0) {
			ans.add(res1);
			ArrayList<Integer> res2 = new ArrayList<>();
			int j = 0;
			for(int i = 0; i<n; i++) {
				if(j<k && arr.get(i)==res1.get(j)) j++;
				else res2.add(arr.get(i));
			}
			ans.add(res2);
		}
		return ans;
	}
	static boolean checkMemo(ArrayList<Integer> arr, int sum, int count, int i) {
		// super fast
		if(count==0) {
			if(sum==0) return true;
			else return false;
		}
		if(i>=arr.size()) return false;
		if(memo[i][sum][count]==false) return false;
		if(arr.get(i)>=sum) {
			res1.add(arr.get(i));
			if(checkMemo(arr, sum-arr.get(i), count-1, i+1)) return true;
			res1.remove(res1.size()-1);
		}
		if(checkMemo(arr, sum, count, i+1)) return true;
		
		return memo[i][sum][count]=false;
	}
	static boolean check(ArrayList<Integer> arr, int sum, int count, int i) {
		if(count==0) {
			if(sum==0) return true;
			else return false;
		}
		if(i>=arr.size()) return false;
		
		if(arr.get(i)<=sum) {
			res1.add(arr.get(i));
			if(check(arr, sum-arr.get(i), count-1, i+1)) return true;
			res1.remove(res1.size()-1);
		}
		
		if(check(arr, sum, count, i+1)) return true;
		
		return false;
	}
	static ArrayList<Integer> input() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) arr.add(scan.nextInt());
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(equalAveragePartition(input()));
	}
}
