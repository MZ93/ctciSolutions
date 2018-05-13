import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
 * 
 * @author Momchil
 *
 */
public class DavisStaircase {
	private static HashMap<Integer, Integer> calculated = new HashMap<>();

	/**
	 * Like the coin change problem this calculates the possible number of ways in
	 * which a staircase can be climbed. I am using memorisation to optimise the
	 * runtime.
	 * 
	 * @param stairs
	 * @return
	 */
	public static int climb(int stairs) {

		if (stairs <= 0 || stairs == 1) {
			return 1;
		} else if (stairs == 2) {
			return 2;
		} else if (stairs == 3) {
			return 4;
		} else

		if (calculated.containsKey(stairs)) {
			return calculated.get(stairs);
		} else {
			calculated.put(stairs, climb(stairs - 1) + climb(stairs - 2) + climb(stairs - 3));
			return calculated.get(stairs);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);

		int s = in.nextInt();

		for (int a0 = 0; a0 < s; a0++) {
			int n = in.nextInt();
			System.out.println(climb(n));

		}

		in.close();
	}

}
