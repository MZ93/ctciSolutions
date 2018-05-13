import java.util.Scanner;
/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 * @author Momchil
 *
 */
public class LeftRotation {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		int[] copy = new int[a.length];

		for (int i = 0; i < copy.length; i++) {
			int j = i + k;
			while (j > n - 1) {
				j = j - n;
				j = 0 + j;

			}

			copy[i] = a[j];

		}

		return copy;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		int[] output = new int[n];
		output = arrayLeftRotation(a, n, k);
		for (int i = 0; i < n; i++)
			System.out.print(output[i] + " ");

		System.out.println();
		in.close();
	}
}