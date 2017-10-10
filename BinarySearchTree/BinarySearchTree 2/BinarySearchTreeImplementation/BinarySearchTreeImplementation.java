//Program to execute the BinarySearchTree.
import java.util.*;
public class BinarySearchTreeImplementation{
	public static void main(String [] args){
		BinarySearchTree tree = new BinarySearchTree();  //create a BST.
		tree.insert(10);
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(9);

		System.out.println("Find 8 : " + tree.find(8).key);
		System.out.println("Find 10 : " + tree.find(10).key);
		System.out.println("Find 20 : " + tree.find(20).key);	
		System.out.println("Find 22 : " + tree.find(22).key);	
		System.out.println("Find 9 : " + tree.find(9).key);
		System.out.println();	
				
		System.out.println("FindNext 8 : " + tree.findNext(8).key);
		System.out.println("FindNext 10 : " + tree.findNext(10).key);
		System.out.println("FindNext 20 : " + tree.findNext(20).key);
		System.out.println("FindNext 22 : " + tree.findNext(22).key);
		System.out.println("FindNext 9 : " + tree.findNext(9).key);
		System.out.println();

		
		
		List<Node> list = tree.rangeSearch(7,23);
		
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i).key + " ");
		}
		System.out.println();
			
		System.out.println();
		tree.delete(10);
		tree.delete(20);
		System.out.println("Find 20 : " + tree.find(20).key);
		tree.delete(9);
		tree.delete(22);
		tree.delete(8);
		System.out.println("Find 8  : " + tree.find(8));
		System.out.println();

		List<Node> list2 = tree.rangeSearch(7,23);

		for(int i=0;i<list2.size();i++){
			System.out.print(list2.get(i).key + " ");
		}
		System.out.println();
		
		
	}
}
		