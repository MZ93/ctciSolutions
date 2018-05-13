import java.util.HashSet;

public class LinkedList {
	/*
	 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if
	 * the list is empty.
	 * 
	 * A Node is defined as: class Node { int data; Node next; }
	 */

	class Node {
		int data;
		Node next;
	}

	/**
	 * Note in the hackerrank website, copy only the method hasCycle for the
	 * solution.
	 * 
	 * @param head
	 * @return
	 */
	boolean hasCycle(Node head) {
		HashSet<Node> nd = new HashSet<>();
		while (head != null) {
			if (nd.add(head)) {
				head = head.next;
			} else {
				return true;
			}
		}
		return false;
	}

}
