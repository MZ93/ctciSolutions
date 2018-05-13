
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 * 
 * This class contains an implementation of bubble sort that keeps track of all
 * the swaps required to sort an array,
 * 
 * @author Momchil
 *
 */
public class Bubble {

	public static void sort(int[] a) {
		int swaps = 0;
		for (int i = 0; i < a.length - 1; i++) {

			for (int j = 0; j < a.length - i - 1; j++) {
				int current = a[j];

				if (a[j] > a[j + 1]) {

					a[j] = a[j + 1];
					a[j + 1] = current;
					swaps++;

				}

			}

		}

		System.out.println("Array is sorted in " + swaps + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] toSort = new int[n];

		for (int i = 0; i < n; i++) {
			toSort[i] = in.nextInt();

		}
		sort(toSort);
		in.close();
	}
}
