
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 * 
 * @author Momchil
 *
 */
public class Brackets {
	/**
	 * Method that checks if a string is balanced, meaning that all brackets inside
	 * are properly and logically closed.
	 * 
	 * @param expression
	 * @return
	 */
	public static boolean isBalanced(String expression) {
		char[] s = expression.toCharArray();

		Stack<Character> open = new Stack<>();

		for (int i = 0; i < s.length; i++) {
			if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
				open.push(s[i]);

			} else {

				try {
					char c = open.pop();

					if (c == '(' && s[i] != ')') {
						return false;
					} else if (c == '[' && s[i] != ']') {
						return false;
					} else if (c == '{' && s[i] != '}') {
						return false;
					}

				} catch (EmptyStackException e) {
					return false;
				}

			}

		}

		if (open.size() > 0) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
		in.close();
	}
}
