/**
 * Binary Search Tree Assignment
 * 
 * 1. write contains (4pts)
 * 2. write traverseInorder (4pts)
 * 3. write randomizedSort (5pts)
 * 4. write delete (5pts)
 * 5. improve insert to self balance using AVL (4pts)
 * 6. improve delete to self balancing using AVL (3pts)
 * 
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BinarySearchTree {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree('d');
		bst.insert('b');
		bst.insert('c');
		bst.insert('d');
		bst.insert('a');
		bst.insert('e');
		bst.insert('g');
		bst.insert('h');
		bst.print();
	}

	private Node root;

	public BinarySearchTree(char c) {
		root = new Node(c);
	}

	public void print() {
		root.print();
	}

	public void insert(char c) {
		insert(c, root);
	}

	/**
	 * insert for an unbalanced BST.
	 * @param c the letter to insert
	 * @param n the root node to insert from
	 * 
	 * PART 5:
	 * modify this function to balance on insert using AVL algorithm
	 * 
	 */
	private void insert(char c, Node n) {
		if(c==n.data) return;						//c already in tree
		else if(c<n.data) {							//c is less than n
			if(n.left==null) n.left = new Node(c); 	//there is no child to the left, add c
			else insert(c, n.left);					//insert c in left subtree
		} else {									//c is greater than n
			if(n.right==null) n.right = new Node(c);//there is no child to the right, add c
			else insert(c, n.right);				//insert c in right subtree
		}
	}

	/**
	 * STEP 1:
	 * determine whether c is in the tree
	 * @param c a letter to look for
	 * @return true if c is in the tree
	 */
	public boolean contains(char c) {
		return false;
	}

	/**
	 * STEP 2:
	 * do an inorder traversal of the tree
	 * ex.
	 * 
	 *        d               
	 *       / \       
     *		/   \      
     *	   /     \     
     *    /       \    
     *    b       e       
     *   / \       \   
     *  /   \       \  
     *  a   c       g   
     *  		     \ 
     *       		  h
     *        
     * should return ['a','b','c','d','e','g','h']
	 */
	public List<Character> traverseInorder() {
		return null;
	}

	/**
	 * STEP 3:
	 * 
	 * Sort the given list by creating a bst from the list.  
	 * Make sure to insert the list in a randomized order, to help 
	 * promote a balanced tree
	 * @param unsorted a list of items
	 * @return a new sorted lest
	 */
	public static List<Character> randomizedSort(List<Character> unsorted) {
		return unsorted;
	}

	/**
	 * STEP 4: complete this function
	 * STEP 6: improve to self balance with AVL
	 * delete the char c from the tree
	 * @param c the letter to delete
	 * @return true if successful, false if it does not exist
	 */
	public boolean delete(char c) {
		return false;
	}

}

class Node {
	char data;
	Node left;
	Node right;

	public Node(char d) {
		data = d;
	}

	public void print() {
		BTreePrinter.printNode(this);
	}

}

/* from http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram */
class BTreePrinter {

	public static void printNode(Node root) {
		int maxLevel = BTreePrinter.maxLevel(root);
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter.printWhitespaces(firstSpaces);

		List<Node> newNodes = new ArrayList<Node>();
		for (Node node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BTreePrinter.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int maxLevel(Node node) {
		if (node == null)
			return 0;

		return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}


}

