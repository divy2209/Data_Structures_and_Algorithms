package HashingQuestions;

import java.util.HashMap;

// https://www.youtube.com/watch?v=EHpS2TBfWQg
// https://github.com/varunu28/InterviewBit-Java-Solutions/blob/master/Hashing/Copy%20List.java
public class Copy_list {
	static RandomListNode copyListMap(RandomListNode head) {
		if(head==null) return head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode curr = head;
		while(curr!=null) {
			map.put(curr, new RandomListNode(curr.data));
			curr = curr.next;
		}
		curr = head;
		while(curr!=null) {
			RandomListNode clone = map.get(curr);
			if(curr.next!=null) clone.next = map.get(curr.next);
			clone.random = map.get(curr.random);
			curr = curr.next;
		}
		return map.get(head);
	}
	static RandomListNode copyList(RandomListNode head) {
		// not working
		// connection from the old list to new won't be completely removed, so not working
		if(head==null) return null;
		RandomListNode clone = new RandomListNode(head.data);
		RandomListNode temp = clone;
		RandomListNode next = null;
		while(head!=null) {
			if(head.next!=null) temp.next = new RandomListNode(head.next.data);
			next = head.next;
			head.next = temp;
			temp.random = head;
			temp = temp.next;
			head = next;
		}
		temp = clone;
		while(temp!=null) {
			temp.random = temp.random.random.next;
			temp = temp.next;
		}
		return clone;
	}
}

class RandomListNode {
	int data;
	RandomListNode next, random;
	RandomListNode(int x) {
		data = x;
		next = null;
		random = null;
	}
}