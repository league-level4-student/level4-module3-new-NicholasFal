package _06_How_Many_Are_Smaller_Than_Me;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are smaller than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */

    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
    	AVLNode<Integer> node = avlTree.getRoot();
    	int count = counter(node, me);
        return count;

    }
    public int counter(AVLNode<Integer> avlTree, int me) {
    	int count = 0;
    	if(avlTree == null) {
    		return count;
    	} 
    	if(avlTree.getValue() < me) {
    		count++;
    		System.out.println(avlTree.getValue());
    	}
    	count += counter(avlTree.getRight(), me);
    	count += counter(avlTree.getLeft(), me);
    	
    	return count;
    }

}
