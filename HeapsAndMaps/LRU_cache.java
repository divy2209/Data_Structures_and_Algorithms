package HeapsAndMaps;

import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;

// https://www.youtube.com/watch?v=LRf9mPcxta8
public class LRU_cache {
	class Node {
		int key, value;
		Node next, prev;
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	int n;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head = null, tail = null;
	public LRU_cache(int capacity) {
		// TODO Auto-generated constructor stub
		map.clear();
		n = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}
	void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
		/*Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;*/
	}
	void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		head.next.prev = node;
		// node.next.prev = node;
		head.next = node;
		node.prev = head;
	}
	int get(int key) {
		if(map.containsKey(key)) {
			Node temp = map.get(key);
			remove(temp);
			insert(temp);
			return temp.value;
		}
		return -1;
	}
	void set(int key, int value) {
		if(map.containsKey(key)) remove(map.get(key));
		if(map.size()==n) remove(tail.prev);
		insert(new Node(key, value));
	}
	
	/*int n;
	HashMap<Integer, Integer> map = new HashMap<>();
	Queue<Integer> q = new LinkedList<>();
	public LRU_cache(int capacity) {
		// TODO Auto-generated constructor stub
		n = capacity;
		map.clear();
		q.clear();
	}
	void update(Queue<Integer> q, int key) {
		int size = q.size();
		while(size-->0) {
			if(q.peek()!=key) q.add(q.peek());
			q.poll();
		}
		q.add(key);
	}
	int get(int key) {
		if(!map.containsKey(key)) return -1;
		update(q, key);
		return map.get(key);
	}
	void set(int key, int value) {
		if(map.containsKey(key)) {
			update(q, key);
		} else if(map.size()==n) {
			int temp = q.poll();
			map.remove(temp);
			q.add(key);
		} else {
			q.add(key);
		}
		map.put(key, value);
	}*/
}