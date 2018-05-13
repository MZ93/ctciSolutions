import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
 * 
 * @author Momchil
 *
 */
public class DfsConnectedCellGrid {

	/**
	 * Method that finds the largest area of connected cells in a nxm matrix.
	 * 
	 * @param mtrx
	 * @return
	 */
	public static int findArea(int[][] mtrx) {
		int cells = 0;
		HashSet<ArrayList<Integer>> explored = new HashSet<>();
		HashMap<Integer, HashSet<ArrayList<Integer>>> areas = new HashMap<>();
		int areaPointer = 0;

		for (int i = 0; i < mtrx.length; i++) {
			for (int j = 0; j < mtrx[i].length; j++) {
				if (mtrx[i][j] == 1) {
					ArrayList<Integer> coordinates = new ArrayList<>();
					coordinates.add(i);
					coordinates.add(j);

					if (!explored.contains(coordinates)) {
						explored.addAll(exploreArea(mtrx, coordinates));
						areas.put(areaPointer, exploreArea(mtrx, coordinates));
						areaPointer++;
					}
				}
			}
		}

		for (int x : areas.keySet()) {
			int areaSize = areas.get(x).size();

			if (areaSize > cells) {
				cells = areaSize;
			}

		}

		return cells;
	}

	/**
	 * Method that explores the matrix in the 8 directions. (Including diagonals)
	 * 
	 * @param mtrx
	 * @param start
	 * @return
	 */
	public static HashSet<ArrayList<Integer>> exploreArea(int[][] mtrx, ArrayList<Integer> start) {
		HashSet<ArrayList<Integer>> area = new HashSet<>();
		Stack<ArrayList<Integer>> dfs = new Stack<>();

		dfs.push(start);

		while (!dfs.isEmpty()) {
			ArrayList<Integer> current = dfs.pop();
			area.add(current);

			ArrayList<Integer> lUp = new ArrayList<>();
			lUp.add(current.get(0) - 1);
			lUp.add(current.get(1) - 1);

			ArrayList<Integer> up = new ArrayList<>();
			up.add(current.get(0) - 1);
			up.add(current.get(1));

			ArrayList<Integer> rUp = new ArrayList<>();
			rUp.add(current.get(0) - 1);
			rUp.add(current.get(1) + 1);

			ArrayList<Integer> l = new ArrayList<>();
			l.add(current.get(0));
			l.add(current.get(1) - 1);

			ArrayList<Integer> r = new ArrayList<>();
			r.add(current.get(0));
			r.add(current.get(1) + 1);

			ArrayList<Integer> ld = new ArrayList<>();
			ld.add(current.get(0) + 1);
			ld.add(current.get(1) - 1);

			ArrayList<Integer> d = new ArrayList<>();
			d.add(current.get(0) + 1);
			d.add(current.get(1));

			ArrayList<Integer> rd = new ArrayList<>();
			rd.add(current.get(0) + 1);
			rd.add(current.get(1) + 1);

			if (valid(mtrx, lUp) && !area.contains(lUp)) {
				dfs.push(lUp);
			}

			if (valid(mtrx, up) && !area.contains(up)) {
				dfs.push(up);
			}

			if (valid(mtrx, rUp) && !area.contains(rUp)) {
				dfs.push(rUp);
			}

			if (valid(mtrx, l) && !area.contains(l)) {
				dfs.push(l);
			}

			if (valid(mtrx, r) && !area.contains(r)) {
				dfs.push(r);
			}

			if (valid(mtrx, ld) && !area.contains(ld)) {
				dfs.push(ld);
			}

			if (valid(mtrx, d) && !area.contains(d)) {
				dfs.push(d);
			}

			if (valid(mtrx, rd) && !area.contains(rd)) {
				dfs.push(rd);
			}

		}

		return area;
	}

	public static boolean valid(int[][] mtrx, ArrayList<Integer> coordinates) {
		boolean valid = false;

		try {
			int x = mtrx[coordinates.get(0)][coordinates.get(1)];

			if (x == 1) {
				return true;
			}
			/**
			 * Bad practice, but i'm lazy
			 */
		} catch (ArrayIndexOutOfBoundsException e) {

			return false;

		}

		return valid;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		System.out.println(findArea(grid));
		in.close();
	}
}
