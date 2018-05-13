import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
 * 
 * @author Momchil
 *
 */
public class ShortestReachGraph {
	/**
	 * BFS from start node and print distances to every other node.
	 * 
	 * @param start
	 * @param graph
	 */
	static void bfsAll(int start, int[][] graph) {
		Queue<Integer> bfs = new ArrayDeque<>(graph.length);
		bfs.add(start);
		bfs.add(Integer.MIN_VALUE);

		HashSet<Integer> explored = new HashSet<>();

		int depth = 0;
		while (!bfs.isEmpty()) {
			int current = bfs.poll();
			/**
			 * Keeping track of the depth. A new level is represented by
			 * Integer.Min_Value
			 */
			if (current == Integer.MIN_VALUE) {
				depth += 6;

				if (bfs.isEmpty()) {
					break;
				} else {
					bfs.add(Integer.MIN_VALUE);
					continue;
				}
			}

			explored.add(current);

			for (int i = 0; i < graph[current].length; i++) {

				if (graph[current][i] != 0 && !explored.contains(i)) {

					bfs.add(i);
					graph[i][current] = 6;
					graph[current][i] = 6;
					/**
					 * If it's larger than 0 we found a longer path.
					 */
					if (graph[start][i] == 0) {
						graph[start][i] = 6 + depth;
						graph[i][start] = 6 + depth;
					}
				}

			}

		}

		/**
		 * Printing the distance
		 */
		String print = "";
		for (int i = 0; i < graph[start].length; i++) {
			if (i != start) {
				if (graph[start][i] == 0) {
					print += -1 + " ";
				} else {
					print += graph[start][i] + " ";
				}
			}
		}

		System.out.println(print.trim());

	}

	/**
	 * Build graph and store as NxN matrix
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int queries = in.nextInt();

		for (int i = 0; i < queries; i++) {
			int nodes = in.nextInt();
			int edges = in.nextInt();
			int[][] graph = new int[nodes][nodes];

			for (int j = 0; j < edges; j++) {
				int nodeA = in.nextInt();
				int nodeB = in.nextInt();
				graph[nodeA - 1][nodeB - 1] = 6;
				graph[nodeB - 1][nodeA - 1] = 6;
			}

			int startNode = in.nextInt();
			bfsAll(startNode - 1, graph);
		}

		in.close();
	}
}
