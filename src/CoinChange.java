import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-coin-change/problem
 * 
 * @author Momchil
 *
 */
public class CoinChange {
	/**
	 * This solves the coin change problem by using dynamic programming.
	 * 
	 * @param cash
	 * @param coins
	 * @return
	 */
	public long change(int cash, int[] coins) {
		long[] combinations = new long[cash + 1];
		combinations[0] = 1;

		for (int coin : coins) {
			for (int i = 1; i < combinations.length; i++) {
				if (i >= coin) {
					combinations[i] += combinations[i - coin];
				}
			}
		}

		return combinations[cash];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = in.nextInt();

		}
		System.out.println(new CoinChange().change(n, coins));
		in.close();
	}
}
