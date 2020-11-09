package lab8_BinaryTrees;

/* This Class builds a BinaryTree<String> from user input & then tests methods from BinaryTree class
 * @author Alexander Gates | B00837129
 * @date November 4th, 2020
 */

import java.util.*;

public class Exercise1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Queue<BinaryTree<String>> trees = new LinkedList<BinaryTree<String>>();
		Queue<BinaryTree<String>> agenda = new LinkedList<BinaryTree<String>>();
	
		System.out.println("Simple Binary Tree Builder (Enter quit to exit)");
		System.out.print("Enter a String:");
		
		//take user input store it in trees queue
		while(!in.hasNext("quit")) {
			System.out.print("Enter a String:");
			String treeData = in.next();
			BinaryTree<String> tree = new BinaryTree<String>();
			tree.makeRoot(treeData);
			trees.add(tree);
		}
		
		in.close();

		//create root of main tree
		BinaryTree<String> trueRoot = new BinaryTree<String>();
		trueRoot = trees.remove();
		agenda.add(trueRoot);
		
		//build the tree
		while(!trees.isEmpty()) {
			//remove head of agenda & trees
			BinaryTree<String> agendaFirst = agenda.remove();
			BinaryTree<String> treesFirst = trees.remove();
			
			//attach head of trees to left of agenda, add it to agenda
			agendaFirst.attachLeft(treesFirst);
			agenda.add(treesFirst);
			
			//if more trees in queue attach them to right of tree previously removed from agenda
			if(!trees.isEmpty()) {
				treesFirst = trees.remove();
				agendaFirst.attachRight(treesFirst);
				agenda.add(treesFirst);
			}
		}
			
		System.out.println("\n");
		//test statements - Provided by Srini
	    System.out.printf("Height of the tree is: %d\n",
	                         BinaryTree.height(trueRoot));

	    System.out.printf("Number of nodes in the tree is: %d\n",
	                          BinaryTree.nodes(trueRoot));

	    System.out.println();

	    System.out.print("Inorder:\t");
		BinaryTree.inorder(trueRoot);
		System.out.println();

	    System.out.print("Preorder:\t");
		BinaryTree.preorder(trueRoot);
		System.out.println();

		System.out.print("Postorder:\t");
		BinaryTree.postorder(trueRoot);
		System.out.println();

		System.out.print("Level order:\t");
		BinaryTree.levelorder(trueRoot);
	}

}
