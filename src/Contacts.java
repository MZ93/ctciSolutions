
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-contacts
 * 
 * This class contains a data structure which implements a contacts
 * functionality as described in the link above.
 * 
 * @author Momchil
 *
 */
public class Contacts {

	HashMap<String, int[]> contacts = new HashMap<>();

	/**
	 * Method that adds a new contact.
	 * 
	 * @param contact
	 */
	public void add(String contact) {

		for (int i = 0; i < contact.length(); i++) {
			if (contacts.containsKey(contact.substring(0, i + 1))) {
				contacts.get(contact.substring(0, i + 1))[0]++;

			} else {
				int[] noCon = new int[1];
				noCon[0] = 1;
				contacts.put(contact.substring(0, i + 1), noCon);

			}
		}

	}

	/**
	 * Method that prints the number of already existing contacts, or 0 if the
	 * contact does not exist.
	 * 
	 * @param con
	 */
	public void print(String con) {
		if (contacts.containsKey(con)) {
			System.out.println(contacts.get(con)[0]);
		} else {
			System.out.println(0);
		}
	}

	public static void main(String[] args) {

		Contacts conn = new Contacts();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if (op.equals("add")) {
				conn.add(contact);
			} else {
				conn.print(contact);
			}
		}
		in.close();
	}
}
