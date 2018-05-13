
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
 * 
 * @author Momchil
 * 
 *         This class is an implementation of a queue using two stacks. All the
 *         standard operations like enqueue, dequeue and peek are supported.
 * @param <T>
 *            The stack type is generic.
 */

public class TwoStacks<T> {
	Stack<T> rear = new Stack<>();
	Stack<T> top = new Stack<>();

	public void enqueue(T t) {
		rear.push(t);
	}

	public T dequeue() {
		if (top.empty()) {
			while (!rear.isEmpty()) {
				top.push(rear.pop());
			}
		}
		return top.pop();
	}

	public T peek() {
		if (top.empty()) {
			while (!rear.isEmpty()) {
				top.push(rear.pop());
			}
		}
		return top.peek();
	}

	public static void main(String[] args) {
		TwoStacks<Integer> queue = new TwoStacks<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}
