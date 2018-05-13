import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 * 
 * This is the comparator implementation required to solve the problem in the
 * link above. Copy only the checker class to the hackerrank solution.
 * 
 * @author Momchil
 *
 */
class Checker implements Comparator<Player> {
	@Override
	public int compare(Player a1, Player a2) {
		if (a1.score != a2.score) {
			return a2.score - a1.score;
		} else {
			return a1.name.compareTo(a2.name);
		}

	}

}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}