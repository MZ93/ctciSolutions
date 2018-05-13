
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 * 
 * This class uses two priority queues to determine the median of an arbitrary
 * set of integers which is constantly changing. To improve the time complexity
 * two priority queues are used.
 * 
 * @author Momchil
 *
 */
public class RunningMedian {
	/**
	 * Method that prints the double precision median of the set of integers..
	 * 
	 * @param a
	 * @param b
	 * @param n
	 */
	public static void printMedian(PriorityQueue<Integer> a, PriorityQueue<Integer> b, int n) {
		if ((n + 1) % 2 != 0) {
			if (a.size() > b.size()) {

				System.out.println((double) a.peek());

			} else {
				System.out.println((double) b.peek());
			}

		} else {
			double mi = (double) a.peek();
			double mi1 = (double) b.peek();
			System.out.println((mi + mi1) / 2);
		}

	}

	/**
	 * Main method which also reads input.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		PriorityQueue<Integer> max = new PriorityQueue<Integer>(1000);
		/**
		 * Using the Comparator interface to change the priority of the queue.
		 */
		PriorityQueue<Integer> min = new PriorityQueue<Integer>(1000, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return (o2 < o1) ? -1 : ((o2 == o1) ? 0 : 1);
			}

		});

		for (int a_i = 0; a_i < n; a_i++) {
			int k = in.nextInt();

			if (a_i % 2 == 0) {
				max.add(k);
			} else {
				min.add(k);
			}

			while (!max.isEmpty() && !min.isEmpty() && max.peek() < min.peek()) {
				int newMin = max.poll();
				int newMax = min.poll();
				min.add(newMin);
				max.add(newMax);

			}

			printMedian(max, min, a_i);
		}

		in.close();
	}

}
