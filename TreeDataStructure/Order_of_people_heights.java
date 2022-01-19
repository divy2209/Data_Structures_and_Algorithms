package TreeDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// https://www.youtube.com/watch?v=khddrw6Bfyw
// https://github.com/SrGrace/InterviewBit/blob/master/Trees/OrderOfPeopleHeights.cpp
public class Order_of_people_heights {
	static ArrayList<Integer> orderOfPeopleHeights(ArrayList<Integer> height, ArrayList<Integer> infront){
		int n = height.size();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<n; i++) map.put(height.get(i), infront.get(i));
		Collections.sort(height);
		ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
		for(int i = 0; i<n; i++) {
			int count = map.get(height.get(i));
			for(int j = 0; j<n; j++) {
				if(ans.get(j)==-1 && count==0) {
					ans.set(j, height.get(i));
					break;
				} else if(ans.get(j)==-1 || ans.get(j)>=height.get(i)) count--;
			}
		}
		return ans;
	}
}
