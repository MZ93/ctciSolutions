import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 * 
 * @author Momchil
 *
 */
public class RansomNote {
	ArrayList<String> magazineMap;
	ArrayList<String> noteMap;
	HashSet<Integer> nodes = new HashSet<>();

	/**
	 * Constructor for the RansomNote object
	 * 
	 * @param magazine
	 * @param note
	 */
	public RansomNote(String magazine, String note) {
		magazineMap = new ArrayList<>();
		noteMap = new ArrayList<>();
		String[] mag = magazine.split(" ");
		String[] nt = note.split(" ");

		for (int i = 0; i < mag.length; i++) {
			magazineMap.add(mag[i]);

		}

		for (int i = 0; i < nt.length; i++) {
			noteMap.add(nt[i]);

		}

		Collections.sort(magazineMap);

	}

	/**
	 * Method that checks if an unsolvable ransom note is possible.
	 * 
	 * @return 
	 */
	public boolean solve() {
		boolean b = true;
		for (String s : noteMap) {
			if (Collections.binarySearch(magazineMap, s) > -1) {

				magazineMap.remove(s);

			} else {

				b = false;
			}
		}

		return b;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
