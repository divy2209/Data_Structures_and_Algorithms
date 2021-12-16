package BacktrackingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://algomantras.tech/subset-interviewbit/
// https://www.youtube.com/watch?v=LdtQAYdYLcE
public class Subset {
	// this can also be done with the graycode approach but won't be sorted, that's all
	static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr){
		Collections.sort(arr);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ans.add(new ArrayList<Integer>());
		generateSubsets(ans, new ArrayList<Integer>(), arr, 0);
		/*ArrayList<String> brr = generateGrayCode(arr.size());
        for(int i = 0; i<brr.size(); i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            String str = brr.get(i);
            for(int j = 0; j<arr.size(); j++){
                if(str.charAt(j)=='1') temp.add(arr.get(j));
            }
            ans.add(temp);
        }*/
		return ans;
	}
	static void generateSubsets(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, ArrayList<Integer> arr, int index) {
		if(index==arr.size()) return;
		ArrayList<Integer> temp = new ArrayList<Integer>(curr);
		temp.add(arr.get(index));
		ans.add(temp);
		generateSubsets(ans, temp, arr, index+1);
		generateSubsets(ans, curr, arr, index+1);
	}
	/*static ArrayList<String> generateGrayCode(int n){
		if(n==1) {
			ArrayList<String> arr = new ArrayList<String>();
			arr.add("0");
			arr.add("1");
			return arr;
		}
		ArrayList<String> arr = generateGrayCode(n-1);
		ArrayList<String> ans = new ArrayList<String>();
		for(int i = 0; i<arr.size(); i++) {
			ans.add("0"+arr.get(i));
		}
		for(int i = arr.size()-1; i>=0; i--) {
			ans.add("1" + arr.get(i));
		}
		return ans;
	}*/
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
		System.out.println(subsets(input()));
	}
}
