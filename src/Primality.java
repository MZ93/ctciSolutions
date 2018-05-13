import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-big-o/problem
 * 
 * @author Momchil
 *
 */
public class Primality {
	/**
	 * The Primality problem in ~O( sqrt(n) ) when calculating for one given
	 * number.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		for (int a0 = 0; a0 < p; a0++) {
			int n = in.nextInt();
			boolean prime = true;
			
			if (n % 2 == 0) {
				prime = false;
			} else {

				for (int i = 3; i <= (Math.sqrt(n) + 1); i += 2) {
					if (n % i == 0) {
						prime = false;
						break;
					}
				}
			}

			prime = (n == 2) ? true : prime;

			prime = (n == 1) ? false : prime;

			if (prime) {
				System.out.println("Prime");
			} else {
				System.out.println("Not prime");
			}
		}
		in.close();
	}
}
