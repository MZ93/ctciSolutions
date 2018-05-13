/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/submissions/code/45138203
 * 
 * @author Momchil
 *
 */
public class CheckBST {

	class Node {
		int data;
		Node left;
		Node right;
	}

	/**
	 * Note in order for this solution to work on hackerrank copy only the remaining
	 * methods.
	 * 
	 */

	/**
	 * Recursive call that checks if the tree meets the requirements of a BST.
	 * 
	 * @param root
	 * @return
	 */
	boolean checkBST(Node root) {
		if (root == null) {
			return true;
		}

		if (root.left == null && root.left != null) {
			return checkBST(root.right);
		}

		if (root.right == null && root.left != null) {
			return checkBST(root.left);
		}
		if (root.left != null && root.right != null)
			if (root.data <= maxEle(root.left) || root.data >= minEle(root.right)) {
				return false;
			}

		return checkBST(root.left) && checkBST(root.right);

	}

	/**
	 * Method that returns the min element from a tree.
	 * 
	 * @param root
	 * @return
	 */
	int minEle(Node root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(Math.min(root.data, minEle(root.left)), Math.min(root.data, minEle(root.right)));
	}

	/**
	 * Method that returns the max element from a tree.
	 * 
	 * @param root
	 * @return
	 */
	int maxEle(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(Math.max(root.data, maxEle(root.left)), Math.max(root.data, maxEle(root.right)));
	}
	/**
	 * Dont copy the last bracket to the hackerrank solution.
	 */
}
