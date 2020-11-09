package lab8_BinaryTrees;

import java.util.ArrayList;

/**
 * Class provided by Srini
 * Certain methods completed by Alexander Gates | B00837129
 * CSCI2110 | November 4th, 2020
 * @param <T>
 */

public class BinaryTree<T>{
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public BinaryTree(){
		parent = left = right = null;
		data = null;
	}

	public void makeRoot(T data){
		if (!isEmpty()){
			System.out.println("Can't make root. Already exists");
		}
		else
			this.data = data;
	}

	public void setData(T data){
		this.data = data;
	}

	public void setLeft(BinaryTree<T> tree){
		left = tree;
	}

	public void setRight(BinaryTree<T> tree){
		right = tree;
	}

	public void setParent(BinaryTree<T> tree){
		parent = tree;
	}

	public T getData(){
		return data;
	}

	public BinaryTree<T> getParent(){
		return parent;
	}

	public BinaryTree<T> getLeft(){
		return left;
	}

	public BinaryTree<T> getRight(){
		return right;
	}

	public void attachLeft(BinaryTree<T> tree){
		if (tree==null) return;
		else if (left!=null || tree.getParent()!=null){
			System.out.println("Can't attach");
			return;
		}
		else{
            tree.setParent(this);
            this.setLeft(tree);
		}
	}

	public void attachRight(BinaryTree<T> tree){
		if (tree==null) return;
		else if (right!=null || tree.getParent()!=null){
			System.out.println("Can't attach");
			return;
		}
		else{
            tree.setParent(this);
            this.setRight(tree);
		}
	}

	public BinaryTree<T> detachLeft(){
		if (this.isEmpty()) return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft!=null) retLeft.setParent(null);
		return retLeft;
	}

	public BinaryTree<T> detachRight(){
		if (this.isEmpty()) return null;
		BinaryTree<T> retRight = right;
		right =null;
		if (retRight!=null) retRight.setParent(null);
		return retRight;
	}

	public boolean isEmpty(){
		if (data == null)
			return true;
		else
			return false;
	}

	public void clear(){
		left = right = parent =null;
		data = null;
	}

	public BinaryTree<T> root(){
		if (parent == null)
			return this;
		else{
			BinaryTree<T> next = parent;
			while (next.getParent()!=null)
				next = next.getParent();
			return next;
		}
	}

	/*Work for Alexander Gates begins here*/
	
	//recursively returns number of nodes in a tree
    public static<T> int nodes(BinaryTree<T> t){
      if(t==null) 
    	  return 0;
      else return 1+nodes(t.getLeft()) + nodes(t.getRight());
    }

    //returns the height of the binary tree
    public static<T> int height(BinaryTree<T> t){
       if(t==null)
    	   return -1;
       else 
    	   return 1+Math.max(height(t.getLeft()), height(t.getRight()));
    }

    //returns true if the height of the left and right subtrees differ by no more than one
    public static<T> boolean isBalanced(BinaryTree<T> t){
        if(Math.abs( height(t.getLeft()) - height(t.getRight()) ) <= 1) 
        	return true;
        else
        	return false;
    }

    public static <T> void preorder(BinaryTree<T> t){
		if (t!=null){
			System.out.print(t.getData()+"\t");
			preorder(t.getLeft());
			preorder(t.getRight());
		}
	}

	public static <T> void inorder(BinaryTree<T> t){
		if (t!=null){
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}

	public static <T> void postorder(BinaryTree<T> t){
		if (t!=null){
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}
	
	//prints the tree in level order
    public static <T> void levelorder(BinaryTree<T> t){
        ArrayList<BinaryTree<T>> levels = new ArrayList<BinaryTree<T>>();
        levels.add(t);
        
        BinaryTree<T> first; 
        
        while(levels.size() > 0) {
        	first = levels.remove(0);
        	System.out.print(first.getData() + "\t");
        	if(first.getLeft() != null)
        			levels.add(first.getLeft());
        	if(first.getRight() != null)
        		levels.add(first.getRight());
        }
	}
}
