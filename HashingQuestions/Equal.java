package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://github.com/cruxrebels/InterviewBit/blob/master/Hashing/Equal.cpp
public class Equal {
	static ArrayList<Integer> equalSumIndexs(ArrayList<Integer> arr){
		ArrayList<Integer> ans = new ArrayList<Integer>(4);
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i<arr.size(); i++) {
			for(int j = i+1; j<arr.size(); j++) {
				int sum = arr.get(i) + arr.get(j);
				if(!map.containsKey(sum)) {
					ArrayList<Integer> pair = new ArrayList<Integer>(2);
					pair.add(i);
					pair.add(j);
					map.put(sum, pair);
				} else {
					ArrayList<Integer> pair = map.get(sum);
					if(pair.get(0)<i && pair.get(1)!=i && pair.get(1)!=j) {
						ArrayList<Integer> temp = new ArrayList<Integer>(pair);
						temp.add(i);
						temp.add(j);
						if(ans.size()==0) {
							ans = temp;
						} else {
							for(int l = 0; l<4; l++) {
								if(ans.get(l)<temp.get(l)) break;
								if(ans.get(l)>temp.get(l)) {
									ans.clear();
									ans = temp;
									break;
								}
							}
						}
					}
				}
			}
		}
		return ans;
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
		System.out.println(equalSumIndexs(input()));
	}
}
