import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-lonely-integer/problem
 * 
 * @author Momchil
 *
 */
public class LonelyInteger {
	/**
	 * This is a O(N) solution
	 * 
	 * xor an array to give out the unique number in the array.
	 * 
	 * @param arr
	 *            The array of integers
	 * @return The lonely integer
	 */
	public static int uniqueN(int[] arr) {

		int element = 0;

		for (int x : arr)
			element ^= x;

		return element;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		System.out.println(uniqueN(a));
		in.close();
	}
}
