
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 * 
 * @author Momchil
 *
 */
public class Anagrams {
	public static int numberNeeded(String first, String second) {
		int[] alphabet = new int[27];
		int[] alphaSc = new int[27];

		for (char c : first.toCharArray()) {

			alphabet[(int) c - 96] += 1;
		}

		for (char c : second.toCharArray()) {
			alphaSc[(int) c - 96] += 1;
		}
		/**
		 * Counting the number of possible anagrams.
		 */
		int counter = 0;

		for (int i = 0; i < alphabet.length; i++) {
			counter += Math.abs(alphabet[i] - alphaSc[i]);

		}

		return counter;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
		in.close();
	}
}
