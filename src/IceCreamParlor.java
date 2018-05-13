import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 * 
 * @author Momchil
 *
 */
public class IceCreamParlor {
	/**
	 * O(N) solution
	 * 
	 * @param flavors
	 * @param money
	 */
	static void solve(int[] flavors, int money) {

		HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();

		for (int x = 0; x < flavors.length; x++) {

			if (map.get(flavors[x]) == null) {

				ArrayDeque<Integer> temp = new ArrayDeque<>();
				temp.add(x);
				map.put(flavors[x], temp);

			} else {

				map.get(flavors[x]).add(x);

			}
		}

		for (int i = 0; i < flavors.length; i++) {
			
			int other = money - flavors[i];

			ArrayDeque<Integer> temp = map.get(other);

			if (temp != null) {

				if (temp.size() == 1) {
					System.out.println((i + 1) + " " + (temp.poll() + 1));
				} else if (temp.size() > 1) {
					System.out.println((temp.poll() + 1) + " " + (temp.poll() + 1));
				}

				break;
			}

		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int money = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			solve(arr, money);
		}
		in.close();
	}
}
