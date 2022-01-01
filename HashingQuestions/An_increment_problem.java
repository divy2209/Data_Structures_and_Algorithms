package HashingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// https://www.interviewbit.com/discussion/p/problem-explanation-for-an-increment-problem/77071/
// https://www.interviewbit.com/discussion/p/c-light-weight-soln/77878/
// https://www.interviewbit.com/discussion/p/easy-to-understand-map-solution-cpp/68855/
public class An_increment_problem {
	static ArrayList<Integer> incremental(ArrayList<Integer> arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<arr.size(); i++) {
			if(map.containsKey(arr.get(i))) {
				int j = map.get(arr.get(i));
				arr.set(j, arr.get(i)+1);
				if(map.containsKey(arr.get(j)/*arr.get(i)+1*/)) {
					map.put(arr.get(j)/*arr.get(i)+1*/, j>map.get(arr.get(j)) ? map.get(arr.get(j)) : j);
				}
				else map.put(arr.get(j)/*arr.get(i)+1*/, map.get(arr.get(i)));
				map.remove(arr.get(i));
				map.put(arr.get(i), i);
			} else map.put(arr.get(i), i);
		}
		/*for(int i = 0; i<arr.size(); i++) {
			int first = arr.indexOf(arr.get(i));
			if(first>=0 && first<i) arr.set(first, arr.get(i)+1);
		}*/
		return arr;
	}
	static ArrayList<Integer> input(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i<n; i++) {
			arr.add(scan.nextInt());
		}
		scan.close();
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(incremental(input()));
	}
}
