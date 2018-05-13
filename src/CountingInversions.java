import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort
 * 
 * This class contains an implementation of merge sort that can keep track of
 * the number of inversions required to sort the array.
 * 
 * @author Momchil
 *
 */
public class CountingInversions {
	private long inversions = 0;

	/**
	 * Merge part of merge sort that also keeps track of inversions and preserves
	 * the NlogN running time of the algorithm.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public int[] merge(int[] left, int[] right) {
		int[] sorted = new int[left.length + right.length];
		int leftPointer = 0;
		int rightPointer = 0;
		int sortedPointer = 0;

		while (leftPointer < left.length && rightPointer < right.length) {
			if (left[leftPointer] <= right[rightPointer]) {
				sorted[sortedPointer] = left[leftPointer];
				leftPointer++;
			} else {
				sorted[sortedPointer] = right[rightPointer];
				/**
				 * Split inversions are equal to the number of remaining elements in the left
				 * array.
				 */
				inversions += left.length - leftPointer;

				rightPointer++;

			}
			sortedPointer++;
		}

		while (leftPointer < left.length) {
			sorted[sortedPointer] = left[leftPointer];
			leftPointer++;
			sortedPointer++;
		}

		while (rightPointer < right.length) {
			sorted[sortedPointer] = right[rightPointer];
			rightPointer++;
			sortedPointer++;

		}

		return sorted;
	}

	/**
	 * Merge sort implementation.
	 * 
	 * @param arr
	 * @return
	 */
	public int[] mergeSort(int[] arr) {
		/**
		 * Recursion base case.
		 */
		if (arr.length <= 1) {
			return arr;
		}
		/**
		 * Initialise new arrays.
		 */
		int[] left = new int[arr.length / 2];
		int[] right = new int[arr.length - (arr.length / 2)];
		int arrPointer = 0;
		int leftPointer = 0;
		int rightPointer = 0;

		while (arrPointer < arr.length) {

			if ((arr.length / 2) > arrPointer) {
				left[leftPointer] = arr[arrPointer];
				leftPointer++;

			} else {
				right[rightPointer] = arr[arrPointer];
				rightPointer++;
			}
			arrPointer++;
		}

		left = mergeSort(left);
		right = mergeSort(right);

		/**
		 * Return merged arrays.
		 */
		return merge(left, right);

	}

	/**
	 * Method that will be used when you want to count the inversions.
	 * 
	 * @param arr
	 * @return
	 */
	public long countInversions(int[] arr) {
		mergeSort(arr);

		return inversions;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			long result = new CountingInversions().countInversions(arr);
			System.out.println(result);
		}
		in.close();

	}
}
